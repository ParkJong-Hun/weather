package presentation.pages.home

import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import common.extension.DEFAULT_STOP_TIME_OUT_MILLIS
import domain.entity.City
import domain.entity.Permission
import domain.entity.PermissionState
import domain.entity.TemperatureType
import domain.entity.WeatherSnapshot
import domain.entity.WeatherType
import domain.entity.toColor
import domain.usecase.GetWeatherByCityUseCase
import domain.usecase.GetWeatherByCurrentLocationUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import presentation.TemperatureColor
import presentation.utility.PermissionUtility

interface HomeViewModelInput {
    fun onClickCity(clickedCity: City)
    fun onClickCurrentLocation()
    fun onClickDialogOkButton()
}

interface HomeViewModelOutput {
    val uiState: StateFlow<HomeUiState>
}

@Stable
data class HomeUiState(
    val title: String = "...",
    val weatherType: WeatherType? = null,
    val temperatureType: TemperatureType? = null,
    val description: String? = null,
    val temperature: String? = null,
    val humidity: String? = null,
    val rainfall: String? = null,
    val errorMessage: String? = null,
    val isLoading: Boolean = false,
    val isShowDialog: Boolean = false,
    val dialogTitle: String? = null,
    val dialogMessage: String? = null,
) {
    val weatherColor: Color
        get() = temperatureType?.toColor() ?: TemperatureColor.Pleasant
}

class HomeViewModel(
    private val getWeatherByCityUseCase: GetWeatherByCityUseCase,
    private val permissionUtility: PermissionUtility,
    getWeatherByCurrentLocationUseCase: GetWeatherByCurrentLocationUseCase,
) : ViewModel(), HomeViewModelInput, HomeViewModelOutput {
    private val city = MutableSharedFlow<City?>(replay = 1)

    init {
        viewModelScope.launch {
            if (permissionUtility.isPermissionAvailable(Permission.LOCATION)) {
                city.tryEmit(null)
            } else {
                // TODO : get recent city from preference
                city.tryEmit(City.Tokyo)
            }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private val weatherSnapshot: StateFlow<WeatherSnapshot?> = city.flatMapLatest { city ->
        city?.let { clickedCity -> getWeatherByCityUseCase(clickedCity) }
            ?: getWeatherByCurrentLocationUseCase()
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(DEFAULT_STOP_TIME_OUT_MILLIS),
        initialValue = null,
    )
    private val weatherInfoError = MutableStateFlow<Throwable?>(null)
    private val isLoading = combine(
        weatherSnapshot,
        weatherInfoError,
    ) { snapshot, error ->
        snapshot == null && error == null
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(DEFAULT_STOP_TIME_OUT_MILLIS),
        initialValue = true,
    )
    private val showDialog = MutableStateFlow<Pair<String, String>?>(null)

    override val uiState: StateFlow<HomeUiState> = combine(
        weatherSnapshot,
        weatherInfoError,
        isLoading,
        showDialog,
    ) { info, error, loading, dialog ->
        HomeUiState(
            title = when {
                info?.location != null -> info.location
                else -> "..."
            },
            weatherType = info?.weatherInfo?.weatherType,
            temperatureType = info?.weatherInfo?.let {
                TemperatureType.find(
                    temperature = it.temperature,
                    rainfall = it.rainfallPerHour,
                    weatherType = it.weatherType,
                )
            },
            description = info?.weatherInfo?.description.let {
                it?.replaceFirstChar { c -> if (c.isLowerCase()) c.titlecase() else c.toString() }
            },
            temperature = info?.let { "${it.weatherInfo.temperature.toInt()} ${it.weatherInfo.temperatureSymbolType.symbol}" },
            humidity = info?.let { "${it.weatherInfo.humidity} $PERCENT" },
            rainfall = info?.let { "${it.weatherInfo.rainfallPerHour} $MILLI_MITER_PER_HOUR" },
            errorMessage = error?.message,
            isLoading = loading,
            isShowDialog = dialog != null,
            dialogTitle = dialog?.first,
            dialogMessage = dialog?.second,
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(DEFAULT_STOP_TIME_OUT_MILLIS),
        initialValue = HomeUiState(),
    )

    override fun onClickCity(clickedCity: City) {
        city.tryEmit(clickedCity)
    }

    override fun onClickCurrentLocation() {
        viewModelScope.launch {
            when (permissionUtility.checkPermission(Permission.LOCATION)) {
                PermissionState.NOT_YET -> {
                    runCatching {
                        permissionUtility.requestPermission(Permission.LOCATION)
                    }.onSuccess {
                        if (permissionUtility.isPermissionAvailable(Permission.LOCATION)) {
                            city.tryEmit(null)
                        } else {
                            showDialog.value =
                                "Permission Error" to "Location permission is not available. Please enable it in the app settings."
                        }
                    }.onFailure {
                        showDialog.value =
                            "Permission Error" to "Location permission is not available. Please enable it in the app settings."
                    }
                }

                PermissionState.AVAILABLE -> {
                    city.tryEmit(null)
                }

                PermissionState.UNAVAILABLE -> {
                    showDialog.value =
                        "Permission Error" to "Location permission is not available. Please enable it in the app settings."
                }
            }
        }
    }

    override fun onClickDialogOkButton() {
        showDialog.value = null
        permissionUtility.openAppSettings()
    }

    companion object {
        private const val PERCENT = "%"
        private const val MILLI_MITER_PER_HOUR = "mm/h"
    }
}
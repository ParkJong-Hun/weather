package presentation.pages.home

import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import common.Log
import common.extension.DEFAULT_STOP_TIME_OUT_MILLIS
import domain.entity.City
import domain.entity.TemperatureType
import domain.entity.WeatherSnapshot
import domain.entity.WeatherType
import domain.entity.toColor
import domain.gateway.repository.WeatherRepository
import domain.usecase.GetWeatherByCurrentLocationUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import presentation.TemperatureColor

interface HomeViewModelInput {
    fun onClickCity(clickedCity: City)
    fun onClickCurrentLocation()
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
) {
    val weatherColor: Color
        get() = temperatureType?.toColor() ?: TemperatureColor.Pleasant
}

class HomeViewModel(
    private val weatherRepository: WeatherRepository,
    getWeatherByCurrentLocationUseCase: GetWeatherByCurrentLocationUseCase,
) : ViewModel(), HomeViewModelInput, HomeViewModelOutput {
    private val city = MutableStateFlow<City?>(null)

    init {
        viewModelScope.launch {
            city.collect {
                Log.d("city: $it")
            }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private val weatherSnapshot: StateFlow<WeatherSnapshot?> = city.flatMapLatest { city ->
        city?.let { clickedCity -> weatherRepository.getWeatherByCity(clickedCity) }
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

    override val uiState: StateFlow<HomeUiState> = combine(
        weatherSnapshot,
        weatherInfoError,
        isLoading,
    ) { info, error, loading ->
        HomeUiState(
            title = when {
                city.value?.japaneseCityName != null -> city.value?.japaneseCityName!!
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
            description = info?.weatherInfo?.description,
            temperature = info?.let { "${it.weatherInfo.temperature.toInt()} ${it.weatherInfo.temperatureSymbolType.symbol}" },
            humidity = info?.let { "${it.weatherInfo.humidity} $PERCENT" },
            rainfall = info?.let { "${it.weatherInfo.rainfallPerHour * 100} $MILLI_MITER_PER_HOUR" },
            errorMessage = error?.message,
            isLoading = loading,
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(DEFAULT_STOP_TIME_OUT_MILLIS),
        initialValue = HomeUiState(),
    )

    override fun onClickCity(clickedCity: City) {
        city.value = clickedCity
    }

    override fun onClickCurrentLocation() {
        city.value = null
    }

    companion object {
        private const val PERCENT = "%"
        private const val MILLI_MITER_PER_HOUR = "mm/h"
    }
}
package presentation.pages.home

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import common.extension.DEFAULT_STOP_TIME_OUT_MILLIS
import domain.entity.City
import domain.entity.WeatherSnapshot
import domain.gateway.repository.WeatherRepository
import domain.usecase.GetWeatherByCurrentLocationUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn

interface HomeViewModelInput {
    fun onClickCity(clickedCity: City)
}

interface HomeViewModelOutput {
    val uiState: StateFlow<HomeUiState>
}

@Stable
data class HomeUiState(
    val title: String = CURRENT_LOCATION,
    val temperature: String? = null,
    val humidity: String? = null,
    val rainfall: String? = null,
    val errorMessage: String? = null,
    val isLoading: Boolean = false,
) {
    companion object {
        const val CURRENT_LOCATION = "Current Location"
    }
}

class HomeViewModel(
    private val weatherRepository: WeatherRepository,
    getWeatherByCurrentLocationUseCase: GetWeatherByCurrentLocationUseCase,
) : ViewModel(), HomeViewModelInput, HomeViewModelOutput {
    private val isLoading = MutableStateFlow(false)
    private val city = MutableStateFlow<City?>(null)

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

    override val uiState: StateFlow<HomeUiState> = combine(
        weatherSnapshot,
        weatherInfoError,
        isLoading,
    ) { info, error, loading ->
        HomeUiState(
            title = weatherSnapshot.value?.let { it.city?.cityName ?: HomeUiState.CURRENT_LOCATION }
                ?: HomeUiState.CURRENT_LOCATION,
            temperature = info?.let { "${it.weather.temperature.toInt()} ${it.weather.temperatureType.symbol}" },
            humidity = info?.let { "${it.weather.humidity} $PERCENT" },
            rainfall = info?.let { "${it.weather.rainfallPerHour * 100} $MILLI_MITER_PER_HOUR" },
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

    companion object {
        private const val PERCENT = "%"
        private const val MILLI_MITER_PER_HOUR = "mm/h"
    }
}
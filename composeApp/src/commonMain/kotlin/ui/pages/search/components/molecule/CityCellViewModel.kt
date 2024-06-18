package ui.pages.search.components.molecule

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.entity.City
import domain.entity.WeatherType
import domain.logger.Log
import domain.usecase.GetWeatherByCityUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.stateIn
import ui.pages.extension.DEFAULT_STOP_TIME_OUT_MILLIS

interface CityCellViewModelOutput {
    val uiState: StateFlow<CityCellUiState>
}

@Immutable
data class CityCellUiState(
    val location: String = "...",
    val degrees: String = "...",
    val weatherType: WeatherType? = null,
)

class CityCellViewModel(
    city: City,
    useCase: GetWeatherByCityUseCase,
) : ViewModel(), CityCellViewModelOutput {
    init {
        Log.d("City: ${city.cityName}, ${useCase.hashCode()}")
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override val uiState: StateFlow<CityCellUiState> = useCase(city).mapLatest {
        CityCellUiState(
            location = it.location,
            degrees = "${it.weatherInfo.temperature}${it.weatherInfo.temperatureSymbolType.symbol}",
            weatherType = it.weatherInfo.weatherType,
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(DEFAULT_STOP_TIME_OUT_MILLIS),
        initialValue = CityCellUiState(),
    )
}
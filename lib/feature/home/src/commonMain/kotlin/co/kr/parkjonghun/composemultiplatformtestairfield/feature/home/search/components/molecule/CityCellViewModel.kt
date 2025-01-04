package co.kr.parkjonghun.composemultiplatformtestairfield.feature.home.search.components.molecule

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.kr.parkjonghun.composemultiplatformtestairfield.application.logger.Log
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.GetWeatherByCityUseCase
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.City
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.WeatherType
import co.kr.parkjonghun.composemultiplatformtestairfield.feature.home.extension.DEFAULT_STOP_TIME_OUT_MILLIS
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.stateIn

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
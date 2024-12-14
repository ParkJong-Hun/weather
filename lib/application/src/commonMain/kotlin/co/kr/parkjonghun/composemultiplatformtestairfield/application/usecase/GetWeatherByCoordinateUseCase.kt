package co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase

import co.kr.parkjonghun.composemultiplatformtestairfield.application.adapter.repository.WeatherRepository
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.Coordinate
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.WeatherSnapshot
import kotlinx.coroutines.flow.Flow

interface GetWeatherByCoordinateUseCase {
    operator fun invoke(coordinate: Coordinate): Flow<WeatherSnapshot>
}

class GetWeatherByCoordinateUseCaseImpl(
    private val weatherRepository: WeatherRepository,
) : GetWeatherByCoordinateUseCase {
    override fun invoke(coordinate: Coordinate): Flow<WeatherSnapshot> =
        weatherRepository.getWeatherByCoordinate(coordinate)
}
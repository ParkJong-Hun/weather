package domain.usecase

import domain.adapter.repository.WeatherRepository
import domain.entity.Coordinate
import domain.entity.WeatherSnapshot
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
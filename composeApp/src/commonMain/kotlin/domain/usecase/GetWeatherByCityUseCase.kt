package domain.usecase

import domain.adapter.repository.WeatherRepository
import domain.entity.City
import domain.entity.WeatherSnapshot
import kotlinx.coroutines.flow.Flow

interface GetWeatherByCityUseCase {
    operator fun invoke(city: City): Flow<WeatherSnapshot>
}

class GetWeatherByCityUseCaseImpl(
    private val weatherRepository: WeatherRepository,
) : GetWeatherByCityUseCase {
    override fun invoke(city: City): Flow<WeatherSnapshot> =
        weatherRepository.getWeatherByCity(city)
}
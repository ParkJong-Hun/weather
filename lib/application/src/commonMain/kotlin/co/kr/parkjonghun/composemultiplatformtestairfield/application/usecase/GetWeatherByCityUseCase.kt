package co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase

import co.kr.parkjonghun.composemultiplatformtestairfield.application.adapter.repository.WeatherRepository
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.City
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.WeatherSnapshot
import kotlinx.coroutines.flow.Flow

interface GetWeatherByCityUseCase {
    operator fun invoke(city: City): Flow<WeatherSnapshot>
}

class GetWeatherByCityUseCaseImpl(
    private val weatherRepository: WeatherRepository,
) : GetWeatherByCityUseCase {
    override fun invoke(city: City): Flow<WeatherSnapshot> {
        co.kr.parkjonghun.composemultiplatformtestairfield.application.logger.Log.d("City UseCase: ${city.cityName}")
        return weatherRepository.getWeatherByCity(city)
    }
}
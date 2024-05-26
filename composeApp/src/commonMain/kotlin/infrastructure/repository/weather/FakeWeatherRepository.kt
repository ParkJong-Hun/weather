package infrastructure.repository.weather

import domain.entity.City
import domain.entity.Coordinate
import domain.entity.WeatherSnapshot
import domain.gateway.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeWeatherRepository : WeatherRepository {
    override fun getWeatherByCoordinate(coordinate: Coordinate): Flow<WeatherSnapshot> = flowOf()

    override fun getWeatherByCity(city: City): Flow<WeatherSnapshot> = flowOf()
}
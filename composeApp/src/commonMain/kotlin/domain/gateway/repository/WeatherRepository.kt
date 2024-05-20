package domain.gateway.repository

import domain.entity.City
import domain.entity.Coordinate
import domain.entity.WeatherInfo
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun getWeatherByCoordinate(coordinate: Coordinate): Flow<WeatherInfo>
    suspend fun getWeatherByCity(city: City): Flow<WeatherInfo>
}
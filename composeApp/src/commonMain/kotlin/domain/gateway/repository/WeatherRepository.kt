package domain.gateway.repository

import domain.entity.Coordinate
import domain.entity.WeatherInfo
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun getWeather(coordinate: Coordinate): Flow<WeatherInfo>
}
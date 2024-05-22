package domain.gateway.repository

import domain.entity.City
import domain.entity.Coordinate
import domain.entity.WeatherInfo
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun getWeatherByCoordinate(coordinate: Coordinate): Flow<WeatherInfo>
    fun getWeatherByCity(city: City): Flow<WeatherInfo>
}
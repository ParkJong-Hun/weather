package domain.gateway.repository

import domain.entity.City
import domain.entity.Coordinate
import domain.entity.WeatherSnapshot
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun getWeatherByCoordinate(coordinate: Coordinate): Flow<WeatherSnapshot>
    fun getWeatherByCity(city: City): Flow<WeatherSnapshot>
}
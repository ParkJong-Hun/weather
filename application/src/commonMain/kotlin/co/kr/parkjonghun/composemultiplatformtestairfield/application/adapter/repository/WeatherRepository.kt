package co.kr.parkjonghun.composemultiplatformtestairfield.application.adapter.repository

import co.kr.parkjonghun.composemultiplatformtestairfield.domain.City
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.Coordinate
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.WeatherSnapshot
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun getWeatherByCoordinate(coordinate: Coordinate): Flow<WeatherSnapshot>
    fun getWeatherByCity(city: City): Flow<WeatherSnapshot>
}
package co.kr.parkjonghun.composemultiplatformairfield.shared.infrastructure.adapter.gateway.repository.weather

import co.kr.parkjonghun.composemultiplatformtestairfield.application.adapter.repository.WeatherRepository
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.City
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.Coordinate
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.WeatherSnapshot
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeWeatherRepository : WeatherRepository {
    override fun getWeatherByCoordinate(coordinate: Coordinate): Flow<WeatherSnapshot> = flowOf()

    override fun getWeatherByCity(city: City): Flow<WeatherSnapshot> = flowOf()
}
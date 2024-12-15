package co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.adapter.mapper

import co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.adapter.mapper.util.toEntity
import co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.api.model.OpenWeatherResponse
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.TemperatureSymbolType
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.WeatherInfo
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.WeatherSnapshot
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.WeatherType

object WeatherInfoEntityMapper : EntityMapper<OpenWeatherResponse, WeatherSnapshot> {
    override fun toEntity(dataModel: OpenWeatherResponse): WeatherSnapshot {
        return WeatherSnapshot(
            location = dataModel.name,
            coordinate = dataModel.coord.toEntity(),
            weatherInfo = WeatherInfo(
                weatherType = WeatherType.fromIcon(dataModel.weather.first().icon),
                description = dataModel.weather.first().description,
                temperature = dataModel.main.temp,
                temperatureSymbolType = TemperatureSymbolType.CELSIUS,
                humidity = dataModel.main.humidity,
                rainfallPerHour = dataModel.rain?.hour ?: 0.0,
            ),
        )
    }
}

fun OpenWeatherResponse.asEntity() = WeatherInfoEntityMapper.toEntity(this)
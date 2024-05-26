package infrastructure.mapper

import domain.entity.TemperatureType
import domain.entity.Weather
import domain.entity.WeatherSnapshot
import infrastructure.mapper.util.toEntity
import infrastructure.model.OpenWeatherResponse

object WeatherInfoEntityMapper : EntityMapper<OpenWeatherResponse, WeatherSnapshot> {
    override fun toEntity(response: OpenWeatherResponse): WeatherSnapshot {
        return WeatherSnapshot(
            city = null,
            coordinate = response.coord.toEntity(),
            weather = Weather(
                description = response.weather.first().description,
                temperature = response.main.temp,
                temperatureType = TemperatureType.CELSIUS,
                humidity = response.main.humidity,
                rainfallPerHour = response.rain?.hour ?: 0.0,
            ),
        )
    }
}

fun OpenWeatherResponse.asEntity() = WeatherInfoEntityMapper.toEntity(this)
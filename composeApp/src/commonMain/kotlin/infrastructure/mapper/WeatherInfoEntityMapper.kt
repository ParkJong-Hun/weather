package infrastructure.mapper

import domain.entity.TemperatureSymbolType
import domain.entity.WeatherInfo
import domain.entity.WeatherSnapshot
import domain.entity.WeatherType
import infrastructure.mapper.util.toEntity
import infrastructure.model.OpenWeatherResponse

object WeatherInfoEntityMapper : EntityMapper<OpenWeatherResponse, WeatherSnapshot> {
    override fun toEntity(response: OpenWeatherResponse): WeatherSnapshot {
        return WeatherSnapshot(
            location = response.name,
            coordinate = response.coord.toEntity(),
            weatherInfo = WeatherInfo(
                weatherType = WeatherType.fromIcon(response.weather.first().icon),
                description = response.weather.first().description,
                temperature = response.main.temp,
                temperatureSymbolType = TemperatureSymbolType.CELSIUS,
                humidity = response.main.humidity,
                rainfallPerHour = response.rain?.hour ?: 0.0,
            ),
        )
    }
}

fun OpenWeatherResponse.asEntity() = WeatherInfoEntityMapper.toEntity(this)
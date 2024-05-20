package infrastructure.mapper

import domain.entity.TemperatureType
import domain.entity.Weather
import domain.entity.WeatherInfo
import infrastructure.mapper.util.toEntity
import infrastructure.model.OpenWeatherResponse

object WeatherInfoEntityMapper : EntityMapper<OpenWeatherResponse, WeatherInfo> {
    override fun toEntity(response: OpenWeatherResponse): WeatherInfo {
        return WeatherInfo(
            city = null,
            coordinate = response.coord.toEntity(),
            weather = Weather(
                temperature = response.main.temp,
                temperatureType = TemperatureType.CELSIUS,
                humidity = response.main.humidity,
                rainfallPerHour = response.rain.hour,
            ),
        )
    }
}

fun OpenWeatherResponse.asEntity() = WeatherInfoEntityMapper.toEntity(this)
package infrastructure.mapper

import domain.entity.TemperatureSymbolType
import domain.entity.WeatherInfo
import domain.entity.WeatherSnapshot
import domain.entity.WeatherType
import infrastructure.mapper.util.toEntity
import infrastructure.model.OpenWeatherResponse

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
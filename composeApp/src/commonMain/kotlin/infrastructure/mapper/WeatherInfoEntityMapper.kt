package infrastructure.mapper

import domain.entity.TemperatureType
import domain.entity.Weather
import domain.entity.WeatherInfo
import infrastructure.mapper.util.toCoordinate
import infrastructure.model.WeatherResponse

object WeatherInfoEntityMapper : EntityMapper<WeatherResponse, WeatherInfo> {
    override fun toEntity(response: WeatherResponse): WeatherInfo {
        return WeatherInfo(
            city = null,
            coordinate = response.ydf.feature.geometry.coordinates.toCoordinate(),
            // TODO
            weather = Weather(
                temperature = 25.0,
                temperatureType = TemperatureType.CELSIUS,
                humidityRate = 0.6,
                rainfallRate = 0.2,
            ),
        )
    }
}

fun WeatherResponse.asEntity() = WeatherInfoEntityMapper.toEntity(this)
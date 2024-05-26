package domain.entity

data class WeatherSnapshot(
    val location: String,
    val coordinate: Coordinate,
    val weatherInfo: WeatherInfo,
)
package domain.entity

data class WeatherSnapshot(
    val city: City?,
    val coordinate: Coordinate,
    val weather: Weather,
)
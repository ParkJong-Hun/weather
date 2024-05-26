package domain.entity

data class WeatherSnapshot(
    val coordinate: Coordinate,
    val weather: Weather,
)
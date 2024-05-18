package domain.entity


data class WeatherInfo(
    val city: City?,
    val coordinate: Coordinate,
    val weather: Weather,
)
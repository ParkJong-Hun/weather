package domain.entity

data class Weather(
    val temperature: Double,
    val temperatureType: TemperatureType,
    val humidity: Int,
    val rainfallPerHour: Double,
)
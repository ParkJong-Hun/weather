package domain.entity

data class Weather(
    val temperature: Double,
    val temperatureType: TemperatureType,
    val humidityRate: Double,
    val rainfallRate: Double,
)
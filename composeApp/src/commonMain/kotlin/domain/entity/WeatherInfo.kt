package domain.entity

data class WeatherInfo(
    val weatherType: WeatherType,
    val description: String,
    val temperature: Double,
    val temperatureSymbolType: TemperatureSymbolType,
    val humidity: Int,
    val rainfallPerHour: Double,
)
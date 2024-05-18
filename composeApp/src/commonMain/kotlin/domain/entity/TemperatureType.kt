package domain.entity

enum class TemperatureType(val symbol: String) {
    CELSIUS(symbol = "°C"),
    FAHRENHEIT(symbol = "°F"),
    KELVIN(symbol = "K"),
    ;

    companion object {
        fun fromString(symbol: String): TemperatureType {
            return entries.firstOrNull { it.symbol == symbol } ?: CELSIUS
        }
    }
}
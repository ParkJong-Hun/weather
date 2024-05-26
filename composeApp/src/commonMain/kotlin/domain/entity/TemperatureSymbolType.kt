package domain.entity

enum class TemperatureSymbolType(val symbol: String) {
    CELSIUS(symbol = "°C"),
    FAHRENHEIT(symbol = "°F"),
    KELVIN(symbol = "K"),
    ;

    companion object {
        fun fromString(symbol: String): TemperatureSymbolType {
            return entries.firstOrNull { it.symbol == symbol } ?: CELSIUS
        }
    }
}
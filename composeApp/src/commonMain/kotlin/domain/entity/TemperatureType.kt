package domain.entity

import ui.TemperatureColor
import ui.WeatherColor

enum class TemperatureType {
    HOT,
    WARM,
    PLEASANT,
    COOL,
    COLD,
    FREEZING,
    CLOUDY,
    RAINY,
    SNOWY,
    ;

    companion object {
        fun find(
            temperature: Double,
            rainfall: Double,
            weatherType: WeatherType,
        ): TemperatureType {
            return when {
                weatherType == WeatherType.BROKEN_CLOUDS -> CLOUDY
                weatherType == WeatherType.THUNDERSTORM -> CLOUDY
                weatherType == WeatherType.MIST -> CLOUDY
                weatherType == WeatherType.SHOWER_RAIN -> RAINY
                weatherType == WeatherType.RAIN -> RAINY
                weatherType == WeatherType.SNOW -> SNOWY

                rainfall != 0.0 -> {
                    when {
                        rainfall < 10.0 -> CLOUDY
                        temperature < 0 -> SNOWY
                        else -> RAINY
                    }
                }

                temperature < 5 -> FREEZING
                temperature < 12 -> COLD
                temperature < 18 -> COOL
                temperature < 26 -> PLEASANT
                temperature < 31 -> WARM
                temperature >= 31 -> HOT

                else -> PLEASANT
            }
        }
    }
}

fun TemperatureType.toColor() = when (this) {
    TemperatureType.HOT -> TemperatureColor.Hot
    TemperatureType.WARM -> TemperatureColor.Warm
    TemperatureType.PLEASANT -> TemperatureColor.Pleasant
    TemperatureType.COOL -> TemperatureColor.Cool
    TemperatureType.COLD -> TemperatureColor.Cold
    TemperatureType.FREEZING -> TemperatureColor.Freezing
    TemperatureType.CLOUDY -> WeatherColor.Cloudy
    TemperatureType.RAINY -> WeatherColor.Rainy
    TemperatureType.SNOWY -> WeatherColor.Snowy
}
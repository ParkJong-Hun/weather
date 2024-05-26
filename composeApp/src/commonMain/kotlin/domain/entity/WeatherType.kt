package domain.entity

import presentation.WeatherColor

enum class WeatherType {
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
        ): WeatherType {
            return when {
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

fun WeatherType.toWeatherColor() = when (this) {
    WeatherType.HOT -> WeatherColor.Hot
    WeatherType.WARM -> WeatherColor.Warm
    WeatherType.PLEASANT -> WeatherColor.Pleasant
    WeatherType.COOL -> WeatherColor.Cool
    WeatherType.COLD -> WeatherColor.Cold
    WeatherType.FREEZING -> WeatherColor.Freezing
    WeatherType.CLOUDY -> WeatherColor.Cloudy
    WeatherType.RAINY -> WeatherColor.Rainy
    WeatherType.SNOWY -> WeatherColor.Snowy
}
package co.kr.parkjonghun.composemultiplatformtestairfield.domain

enum class WeatherType {
    SUNNY,
    FEW_CLOUDS,
    SCATTERED_CLOUDS,
    BROKEN_CLOUDS,
    SHOWER_RAIN,
    RAIN,
    SNOW,
    THUNDERSTORM,
    MIST,
    ;

    companion object {
        fun fromIcon(icon: String): WeatherType {
            return when (icon) {
                "01d",
                "01n" -> SUNNY

                "02d",
                "02n" -> FEW_CLOUDS

                "03d",
                "03n" -> SCATTERED_CLOUDS

                "04d",
                "04n" -> BROKEN_CLOUDS

                "09d",
                "09n" -> SHOWER_RAIN

                "10d",
                "10n" -> RAIN

                "11d",
                "11n" -> THUNDERSTORM

                "13d",
                "13n" -> SNOW

                "50d",
                "50n" -> MIST

                else -> SUNNY
            }
        }
    }
}
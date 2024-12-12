package ui

import androidx.compose.ui.graphics.Color
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.TemperatureType

object TemperatureColor {
    val Hot = Color(0xFFc92913)
    val Warm = Color(0xFFFFA500)
    val Pleasant = Color(0xFF068800)
    val Cool = Color(0xFF008861)
    val Cold = Color(0xFF007a88)
    val Freezing = Color(0xFF1b748c)
}

object WeatherColor {
    val Cloud = Color(0xFFcbcbcb)
    val Sun = Color(0xFFffbc52)
    val Rain = Color(0xFFa0cdd8)
    val Snow = Color(0xFFb3d5df)

    val Cloudy = Color(0xFF708090)
    val Rainy = Color(0xFF00478d)
    val Snowy = Color(0xFFe6f3ff)
}

object Color {
    val Link = Color(0xFF0C43B7)
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
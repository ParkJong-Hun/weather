package co.kr.parkjonghun.composemultiplatformtestairfield.domain

data class WeatherSnapshot(
    val location: String,
    val coordinate: Coordinate,
    val weatherInfo: WeatherInfo,
)
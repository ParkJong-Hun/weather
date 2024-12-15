package co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OpenWeatherResponse(
    @SerialName("coord")
    val coord: OpenWeatherResponseCoord,
    @SerialName("weather")
    val weather: List<OpenWeatherResponseWeather>,
    @SerialName("base")
    val base: String,
    @SerialName("main")
    val main: OpenWeatherResponseMain,
    @SerialName("visibility")
    val visibility: Int,
    @SerialName("wind")
    val wind: OpenWeatherResponseWind,
    @SerialName("rain")
    val rain: OpenWeatherResponseRain? = null,
    @SerialName("clouds")
    val clouds: OpenWeatherResponseClouds,
    @SerialName("dt")
    val dt: Int,
    @SerialName("sys")
    val sys: OpenWeatherResponseSys,
    @SerialName("timezone")
    val timezone: Int,
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("cod")
    val cod: Int,
)

@Serializable
data class OpenWeatherResponseCoord(
    @SerialName("lon")
    val lon: Double,
    @SerialName("lat")
    val lat: Double,
)

@Serializable
data class OpenWeatherResponseWeather(
    @SerialName("id")
    val id: Int,
    @SerialName("main")
    val main: String,
    @SerialName("description")
    val description: String,
    @SerialName("icon")
    val icon: String,
)

@Serializable
data class OpenWeatherResponseMain(
    @SerialName("temp")
    val temp: Double,
    @SerialName("feels_like")
    val feelsLike: Double,
    @SerialName("temp_min")
    val tempMin: Double,
    @SerialName("temp_max")
    val tempMax: Double,
    @SerialName("pressure")
    val pressure: Int,
    @SerialName("humidity")
    val humidity: Int,
    @SerialName("sea_level")
    val seaLevel: Int? = null,
    @SerialName("grnd_level")
    val grndLevel: Int? = null,
)

@Serializable
data class OpenWeatherResponseWind(
    @SerialName("speed")
    val speed: Double,
    @SerialName("deg")
    val deg: Int,
)

@Serializable
data class OpenWeatherResponseRain(
    @SerialName("1h")
    val hour: Double,
)

@Serializable
data class OpenWeatherResponseClouds(
    @SerialName("all")
    val all: Int,
)

@Serializable
data class OpenWeatherResponseSys(
    @SerialName("type")
    val type: Int? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("country")
    val country: String? = null,
    @SerialName("sunrise")
    val sunrise: Int,
    @SerialName("sunset")
    val sunset: Int,
)
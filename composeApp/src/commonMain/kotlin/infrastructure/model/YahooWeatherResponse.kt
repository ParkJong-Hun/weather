package infrastructure.model

import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    val ydf: Ydf,
)

@Serializable
data class Ydf(
    val resultInfo: ResultInfo,
    val feature: Feature,
)

@Serializable
data class ResultInfo(
    val count: Int,
    val total: Int,
    val start: Int,
    val status: Int,
    val latency: Double,
    val description: String?,
)

@Serializable
data class Feature(
    val id: String,
    val name: String,
    val geometry: Geometry,
    val property: Property,
)

@Serializable
data class Geometry(
    val type: String,
    val coordinates: List<Double>,
)

@Serializable
data class Property(
    val weatherAreaCode: String,
    val weatherList: List<Weather>,
)

@Serializable
data class Weather(
    val type: String,
    val date: String,
    val rainfall: Double,
)

@Serializable
data class WeatherErrorResponse(
    val code: String,
    val message: String,
)
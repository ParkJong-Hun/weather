package co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OpenWeatherErrorResponse(
    @SerialName("cod")
    val errorCode: Int,
    @SerialName("message")
    val errorMessage: String,
)
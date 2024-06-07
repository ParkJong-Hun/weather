package infrastructure.api

import co.kr.parkjonghun.composemultiplatformtestairfield.BuildKonfig
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Query
import infrastructure.model.OpenWeatherResponse

private enum class OpenWeatherUnits(val value: String?) {
    /** Returns temperature in degrees Celsius. */
    METRIC("metric"),

    IMPERIAL("imperial"),

    DEFAULT(null),
}

interface OpenWeatherApi {
    @GET("weather")
    suspend fun getWeatherByCoordinate(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appid: String = BuildKonfig.WEATHER_APP_ID,
        @Query("units") units: String = OpenWeatherUnits.METRIC.value!!,
        @Query("lang") lang: String,
    ): OpenWeatherResponse

    @GET("weather")
    suspend fun getWeatherByCityName(
        @Query("q") cityName: String,
        @Query("appid") appid: String = BuildKonfig.WEATHER_APP_ID,
        @Query("units") units: String = OpenWeatherUnits.METRIC.value!!,
        @Query("lang") lang: String,
    ): OpenWeatherResponse
}
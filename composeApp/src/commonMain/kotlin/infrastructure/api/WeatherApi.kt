package infrastructure.api

import de.jensklingenberg.ktorfit.http.GET
import infrastructure.model.WeatherRequest

interface WeatherApi {
    @GET
    suspend fun getWeather(request: WeatherRequest): String//WeatherResponse
}
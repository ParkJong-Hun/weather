package infrastructure.api

import de.jensklingenberg.ktorfit.http.GET
import infrastructure.model.WeatherRequest
import infrastructure.model.WeatherResponse

interface WeatherApi {
    @GET
    suspend fun getWeather(request: WeatherRequest): WeatherResponse
}
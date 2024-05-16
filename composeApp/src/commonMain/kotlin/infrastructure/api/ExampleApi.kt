package infrastructure.api

import de.jensklingenberg.ktorfit.http.GET

interface ExampleApi {
    @GET("people/1/")
    suspend fun getPerson(): String
}
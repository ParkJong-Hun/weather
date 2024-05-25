package infrastructure.di

import de.jensklingenberg.ktorfit.Ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val infrastructureModule = module {
    includes(
        apiModule,
        repositoryModule,
    )
    single<HttpClient> {
        HttpClient {
            engine {}
            install(ContentNegotiation) {
                json(
                    Json {
                        encodeDefaults = true
                        isLenient = true
                        allowSpecialFloatingPointValues = true
                        allowStructuredMapKeys = true
                        prettyPrint = false
                        useArrayPolymorphism = false
                        ignoreUnknownKeys = true
                    }
                )
            }
        }
    }
    single<Ktorfit>(qualifier = KtorfitConfig.OpenWeather.qualifier) {
        Ktorfit.Builder()
            .httpClient(client = get())
            .baseUrl(KtorfitConfig.OpenWeather.baseUrl)
            .build()
    }
}
package infrastructure.di

import common.Log
import de.jensklingenberg.ktorfit.Ktorfit
import infrastructure.permission.PermissionService
import infrastructure.permission.PermissionServiceImpl
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
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
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Log.v(message)
                    }
                }
                level = LogLevel.ALL
            }
        }
    }
    single<Ktorfit>(qualifier = KtorfitConfig.OpenWeather.qualifier) {
        Ktorfit.Builder()
            .httpClient(client = get())
            .baseUrl(KtorfitConfig.OpenWeather.baseUrl)
            .build()
    }
    single<PermissionService> { PermissionServiceImpl(get()) }
}
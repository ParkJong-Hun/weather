package co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.di

import co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.adapter.gateway.preferences.di.preferencesModule
import co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.api.di.KtorfitConfig
import co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.api.di.apiModule
import co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.repository.di.repositoryModule
import co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.adapter.controller.device.di.deviceModule
import co.kr.parkjonghun.composemultiplatformtestairfield.application.logger.Log
import de.jensklingenberg.ktorfit.Ktorfit
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
        deviceModule,
        preferencesModule,
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
}
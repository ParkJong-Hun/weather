package co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.api.di

import co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.api.OpenWeatherApi
import co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.api.createOpenWeatherApi
import de.jensklingenberg.ktorfit.Ktorfit
import org.koin.dsl.module

val apiModule = module {
    single<OpenWeatherApi> { get<Ktorfit>(KtorfitConfig.OpenWeather.qualifier).createOpenWeatherApi() }
}
package co.kr.parkjonghun.composemultiplatformairfield.shared.infrastructure.api.di

import co.kr.parkjonghun.composemultiplatformairfield.shared.infrastructure.api.OpenWeatherApi
import de.jensklingenberg.ktorfit.Ktorfit
import org.koin.dsl.module

val apiModule = module {
    single<OpenWeatherApi> { get<Ktorfit>(KtorfitConfig.OpenWeather.qualifier).create() }
}
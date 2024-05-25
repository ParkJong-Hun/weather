package infrastructure.di

import de.jensklingenberg.ktorfit.Ktorfit
import infrastructure.api.OpenWeatherApi
import org.koin.dsl.module

val apiModule = module {
    single<OpenWeatherApi> { get<Ktorfit>(KtorfitConfig.OpenWeather.qualifier).create() }
}
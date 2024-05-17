package infrastructure.di

import de.jensklingenberg.ktorfit.Ktorfit
import infrastructure.api.DummyApi
import infrastructure.api.DummyApiImpl
import infrastructure.api.ExampleApi
import infrastructure.api.WeatherApi
import org.koin.dsl.module

val apiModule = module {
    single<DummyApi> { DummyApiImpl() }
    single<ExampleApi> { get<Ktorfit>(KtorfitConfig.Example.qualifier).create() }
    single<WeatherApi> { get<Ktorfit>(KtorfitConfig.YahooWeather.qualifier).create() }
}
package infrastructure.di

import domain.gateway.repository.WeatherRepository
import infrastructure.repository.weather.WeatherRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<WeatherRepository> { WeatherRepositoryImpl(openWeatherApi = get()) }
}
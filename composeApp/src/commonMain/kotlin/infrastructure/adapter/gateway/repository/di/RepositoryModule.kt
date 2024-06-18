package infrastructure.adapter.gateway.repository.di

import domain.adapter.repository.WeatherRepository
import infrastructure.adapter.gateway.repository.weather.WeatherRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<WeatherRepository> {
        WeatherRepositoryImpl(
            openWeatherApi = get(),
            getLocaleUseCase = get(),
        )
    }
}
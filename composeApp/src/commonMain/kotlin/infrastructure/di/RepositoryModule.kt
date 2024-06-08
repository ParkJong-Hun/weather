package infrastructure.di

import domain.adapter.repository.WeatherRepository
import infrastructure.adapter.repository.weather.WeatherRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<WeatherRepository> {
        WeatherRepositoryImpl(
            openWeatherApi = get(),
            getLocaleUseCase = get(),
        )
    }
}
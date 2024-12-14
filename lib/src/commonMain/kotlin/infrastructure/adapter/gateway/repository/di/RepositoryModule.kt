package infrastructure.adapter.gateway.repository.di

import co.kr.parkjonghun.composemultiplatformtestairfield.application.adapter.repository.WeatherRepository
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
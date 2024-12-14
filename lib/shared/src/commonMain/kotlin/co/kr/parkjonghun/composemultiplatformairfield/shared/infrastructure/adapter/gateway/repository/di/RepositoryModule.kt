package co.kr.parkjonghun.composemultiplatformairfield.shared.infrastructure.adapter.gateway.repository.di

import co.kr.parkjonghun.composemultiplatformairfield.shared.infrastructure.adapter.gateway.repository.weather.WeatherRepositoryImpl
import co.kr.parkjonghun.composemultiplatformtestairfield.application.adapter.repository.WeatherRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<WeatherRepository> {
        WeatherRepositoryImpl(
            openWeatherApi = get(),
            getLocaleUseCase = get(),
        )
    }
}
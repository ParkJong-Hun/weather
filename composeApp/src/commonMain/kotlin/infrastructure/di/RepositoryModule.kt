package infrastructure.di

import domain.gateway.repository.DummyRepository
import domain.gateway.repository.ExampleRepository
import domain.gateway.repository.WeatherRepository
import infrastructure.repository.dummy.DummyRepositoryImpl
import infrastructure.repository.example.ExampleRepositoryImpl
import infrastructure.repository.weather.WeatherRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<DummyRepository> { DummyRepositoryImpl(dummyApi = get()) }
    single<ExampleRepository> { ExampleRepositoryImpl(exampleApi = get()) }
    single<WeatherRepository> { WeatherRepositoryImpl(weatherApi = get()) }
}
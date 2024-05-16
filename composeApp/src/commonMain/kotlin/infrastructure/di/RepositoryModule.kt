package infrastructure.di

import domain.gateway.repository.DummyRepository
import domain.gateway.repository.ExampleRepository
import infrastructure.repository.DummyRepositoryImpl
import infrastructure.repository.ExampleRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<DummyRepository> { DummyRepositoryImpl(dummyApi = get()) }
    single<ExampleRepository> { ExampleRepositoryImpl(exampleApi = get()) }
}
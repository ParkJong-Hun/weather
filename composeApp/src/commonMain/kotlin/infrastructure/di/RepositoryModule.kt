package infrastructure.di

import domain.gateway.repository.DummyRepository
import infrastructure.repository.DummyRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<DummyRepository> { DummyRepositoryImpl(dummyApi = get()) }
}
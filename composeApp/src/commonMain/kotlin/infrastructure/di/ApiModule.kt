package infrastructure.di

import infrastructure.api.DummyApi
import infrastructure.api.DummyApiImpl
import org.koin.dsl.module

val apiModule = module {
    single<DummyApi> { DummyApiImpl() }
}
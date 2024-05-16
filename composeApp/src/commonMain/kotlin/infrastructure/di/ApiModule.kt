package infrastructure.di

import de.jensklingenberg.ktorfit.Ktorfit
import infrastructure.api.DummyApi
import infrastructure.api.DummyApiImpl
import infrastructure.api.ExampleApi
import org.koin.core.qualifier.named
import org.koin.dsl.module

val apiModule = module {
    single<DummyApi> { DummyApiImpl() }
    single<ExampleApi> { get<Ktorfit>(named("exampleKtorfit")).create() }
}
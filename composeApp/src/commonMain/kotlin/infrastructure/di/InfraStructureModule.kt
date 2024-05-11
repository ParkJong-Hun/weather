package infrastructure.di

import org.koin.dsl.module

val infrastructureModule = module {
    includes(
        apiModule,
        repositoryModule,
    )
}
package domain.di

import domain.usecase.di.useCaseModule
import org.koin.dsl.module

internal val domainModule = module {
    includes(
        useCaseModule,
    )
}
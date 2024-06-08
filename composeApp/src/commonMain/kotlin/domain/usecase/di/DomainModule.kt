package domain.usecase.di

import domain.di.useCaseModule
import org.koin.dsl.module

internal val domainModule = module {
    includes(
        useCaseModule,
    )
}
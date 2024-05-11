package domain.di

import domain.usecase.GreetingUseCase
import domain.usecase.GreetingUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<GreetingUseCase> { GreetingUseCaseImpl() }
}
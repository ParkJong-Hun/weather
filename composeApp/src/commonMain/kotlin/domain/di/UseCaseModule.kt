package domain.di

import domain.usecase.GetCurrentLocationUseCase
import domain.usecase.GetCurrentLocationUseCaseImpl
import domain.usecase.GetWeatherByCurrentLocationUseCase
import domain.usecase.GetWeatherByCurrentLocationUseCaseImpl
import domain.usecase.GreetingUseCase
import domain.usecase.GreetingUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<GreetingUseCase> { GreetingUseCaseImpl() }
    single<GetCurrentLocationUseCase> { GetCurrentLocationUseCaseImpl() }
    single<GetWeatherByCurrentLocationUseCase> {
        GetWeatherByCurrentLocationUseCaseImpl(
            getCurrentLocationUseCase = get(),
            weatherRepository = get(),
        )
    }
}
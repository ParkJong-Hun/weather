package domain.di

import domain.usecase.GetCurrentLocationUseCase
import domain.usecase.GetCurrentLocationUseCaseImpl
import domain.usecase.GetWeatherByCurrentLocationUseCase
import domain.usecase.GetWeatherByCurrentLocationUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<GetCurrentLocationUseCase> { GetCurrentLocationUseCaseImpl() }
    single<GetWeatherByCurrentLocationUseCase> {
        GetWeatherByCurrentLocationUseCaseImpl(
            getCurrentLocationUseCase = get(),
            weatherRepository = get(),
        )
    }
}
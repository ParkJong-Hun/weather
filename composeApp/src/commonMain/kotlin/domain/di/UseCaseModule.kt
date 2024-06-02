package domain.di

import domain.usecase.FindNearestCityCoordinateUseCase
import domain.usecase.FindNearestCityCoordinateUseCaseImpl
import domain.usecase.GetCurrentLocationUseCase
import domain.usecase.GetCurrentLocationUseCaseImpl
import domain.usecase.GetDistanceUseCase
import domain.usecase.GetDistanceUseCaseImpl
import domain.usecase.GetRadiansUseCase
import domain.usecase.GetRadiansUseCaseImpl
import domain.usecase.GetWeatherByCurrentLocationUseCase
import domain.usecase.GetWeatherByCurrentLocationUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<GetCurrentLocationUseCase> {
        GetCurrentLocationUseCaseImpl(
            locationService = get(),
        )
    }
    single<GetWeatherByCurrentLocationUseCase> {
        GetWeatherByCurrentLocationUseCaseImpl(
            getCurrentLocationUseCase = get(),
            weatherRepository = get(),
        )
    }
    single<GetRadiansUseCase> { GetRadiansUseCaseImpl() }
    single<GetDistanceUseCase> {
        GetDistanceUseCaseImpl(
            getRadiansUseCase = get(),
        )
    }
    single<FindNearestCityCoordinateUseCase> {
        FindNearestCityCoordinateUseCaseImpl(
            getDistanceUseCase = get(),
        )
    }
}
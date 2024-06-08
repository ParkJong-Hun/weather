package domain.di

import domain.usecase.CheckPermissionUseCase
import domain.usecase.CheckPermissionUseCaseImpl
import domain.usecase.FindNearestCityCoordinateUseCase
import domain.usecase.FindNearestCityCoordinateUseCaseImpl
import domain.usecase.GetCurrentLocationUseCase
import domain.usecase.GetCurrentLocationUseCaseImpl
import domain.usecase.GetDistanceUseCase
import domain.usecase.GetDistanceUseCaseImpl
import domain.usecase.GetLocaleUseCase
import domain.usecase.GetLocaleUseCaseImpl
import domain.usecase.GetRadiansUseCase
import domain.usecase.GetRadiansUseCaseImpl
import domain.usecase.GetWeatherByCityUseCase
import domain.usecase.GetWeatherByCityUseCaseImpl
import domain.usecase.GetWeatherByCoordinateUseCase
import domain.usecase.GetWeatherByCoordinateUseCaseImpl
import domain.usecase.GetWeatherByCurrentLocationUseCase
import domain.usecase.GetWeatherByCurrentLocationUseCaseImpl
import domain.usecase.IsPermissionAvailableUseCase
import domain.usecase.IsPermissionAvailableUseCaseImpl
import domain.usecase.OpenAppSettingsUseCase
import domain.usecase.OpenAppSettingsUseCaseImpl
import domain.usecase.RequestPermissionUseCase
import domain.usecase.RequestPermissionUseCaseImpl
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
    single<GetLocaleUseCase> {
        GetLocaleUseCaseImpl(
            localeService = get(),
        )
    }
    single<GetWeatherByCoordinateUseCase> {
        GetWeatherByCoordinateUseCaseImpl(
            weatherRepository = get(),
        )
    }
    single<GetWeatherByCityUseCase> {
        GetWeatherByCityUseCaseImpl(
            weatherRepository = get(),
        )
    }
    single<RequestPermissionUseCase> {
        RequestPermissionUseCaseImpl(
            permissionService = get(),
        )
    }
    single<CheckPermissionUseCase> {
        CheckPermissionUseCaseImpl(
            permissionService = get(),
        )
    }
    single<IsPermissionAvailableUseCase> {
        IsPermissionAvailableUseCaseImpl(
            permissionService = get(),
        )
    }
    single<OpenAppSettingsUseCase> {
        OpenAppSettingsUseCaseImpl(
            permissionService = get(),
        )
    }
}
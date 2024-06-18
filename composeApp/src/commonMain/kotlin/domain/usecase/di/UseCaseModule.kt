package domain.usecase.di

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
import domain.usecase.GetSelectedCityUseCase
import domain.usecase.GetSelectedCityUseCaseImpl
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
import domain.usecase.UpdateSelectedCityUseCase
import domain.usecase.UpdateSelectedCityUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    factory<GetCurrentLocationUseCase> {
        GetCurrentLocationUseCaseImpl(
            locationService = get(),
        )
    }
    factory<GetWeatherByCurrentLocationUseCase> {
        GetWeatherByCurrentLocationUseCaseImpl(
            getCurrentLocationUseCase = get(),
            weatherRepository = get(),
        )
    }
    factory<GetRadiansUseCase> { GetRadiansUseCaseImpl() }
    factory<GetDistanceUseCase> {
        GetDistanceUseCaseImpl(
            getRadiansUseCase = get(),
        )
    }
    factory<FindNearestCityCoordinateUseCase> {
        FindNearestCityCoordinateUseCaseImpl(
            getDistanceUseCase = get(),
        )
    }
    factory<GetLocaleUseCase> {
        GetLocaleUseCaseImpl(
            localeService = get(),
        )
    }
    factory<GetWeatherByCoordinateUseCase> {
        GetWeatherByCoordinateUseCaseImpl(
            weatherRepository = get(),
        )
    }
    factory<GetWeatherByCityUseCase> {
        GetWeatherByCityUseCaseImpl(
            weatherRepository = get(),
        )
    }
    factory<RequestPermissionUseCase> {
        RequestPermissionUseCaseImpl(
            permissionService = get(),
        )
    }
    factory<CheckPermissionUseCase> {
        CheckPermissionUseCaseImpl(
            permissionService = get(),
        )
    }
    factory<IsPermissionAvailableUseCase> {
        IsPermissionAvailableUseCaseImpl(
            permissionService = get(),
        )
    }
    factory<OpenAppSettingsUseCase> {
        OpenAppSettingsUseCaseImpl(
            permissionService = get(),
        )
    }
    factory<GetSelectedCityUseCase> {
        GetSelectedCityUseCaseImpl(
            preferences = get(),
        )
    }
    factory<UpdateSelectedCityUseCase> {
        UpdateSelectedCityUseCaseImpl(
            preferences = get(),
        )
    }
}
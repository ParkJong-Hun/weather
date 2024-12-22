package co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.di

import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.CheckPermissionUseCase
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.CheckPermissionUseCaseImpl
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.FindNearestCityCoordinateUseCase
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.FindNearestCityCoordinateUseCaseImpl
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.GetCurrentLocationUseCase
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.GetCurrentLocationUseCaseImpl
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.GetDistanceUseCase
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.GetDistanceUseCaseImpl
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.GetLibraryLicensesUseCase
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.GetLibraryLicensesUseCaseImpl
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.GetLocaleUseCase
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.GetLocaleUseCaseImpl
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.GetRadiansUseCase
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.GetRadiansUseCaseImpl
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.GetSelectedCityUseCase
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.GetSelectedCityUseCaseImpl
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.GetWeatherByCityUseCase
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.GetWeatherByCityUseCaseImpl
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.GetWeatherByCoordinateUseCase
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.GetWeatherByCoordinateUseCaseImpl
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.GetWeatherByCurrentLocationUseCase
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.GetWeatherByCurrentLocationUseCaseImpl
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.IsPermissionAvailableUseCase
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.IsPermissionAvailableUseCaseImpl
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.OpenAppSettingsUseCase
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.OpenAppSettingsUseCaseImpl
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.RequestPermissionUseCase
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.RequestPermissionUseCaseImpl
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.UpdateSelectedCityUseCase
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.UpdateSelectedCityUseCaseImpl
import org.koin.dsl.module

internal val useCaseModule = module {
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
    factory<GetLibraryLicensesUseCase> {
        GetLibraryLicensesUseCaseImpl(
            libraryLicenseService = get(),
        )
    }
}
package co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.adapter.controller.device.di

import co.kr.parkjonghun.composemultiplatformtestairfield.application.adapter.device.LibraryLicenseService
import co.kr.parkjonghun.composemultiplatformtestairfield.application.adapter.device.LocaleService
import co.kr.parkjonghun.composemultiplatformtestairfield.application.adapter.device.LocationService
import co.kr.parkjonghun.composemultiplatformtestairfield.application.adapter.device.PermissionService
import co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.adapter.controller.device.LibraryLicenseServiceImpl
import co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.adapter.controller.device.LocaleServiceImpl
import co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.adapter.controller.device.LocationServiceImpl
import co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.adapter.controller.device.PermissionServiceImpl
import org.koin.dsl.module

val deviceModule = module {
    single<PermissionService> { PermissionServiceImpl(get()) }
    single<LocationService> { LocationServiceImpl() }
    single<LocaleService> { LocaleServiceImpl() }
    single<LibraryLicenseService> { LibraryLicenseServiceImpl() }
}
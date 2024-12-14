package co.kr.parkjonghun.composemultiplatformairfield.shared.infrastructure.adapter.controller.device.di

import co.kr.parkjonghun.composemultiplatformairfield.shared.infrastructure.adapter.controller.device.LocaleServiceImpl
import co.kr.parkjonghun.composemultiplatformairfield.shared.infrastructure.adapter.controller.device.LocationServiceImpl
import co.kr.parkjonghun.composemultiplatformairfield.shared.infrastructure.adapter.controller.device.PermissionServiceImpl
import co.kr.parkjonghun.composemultiplatformtestairfield.application.adapter.device.LocaleService
import co.kr.parkjonghun.composemultiplatformtestairfield.application.adapter.device.LocationService
import co.kr.parkjonghun.composemultiplatformtestairfield.application.adapter.device.PermissionService
import org.koin.dsl.module

val deviceModule = module {
    single<PermissionService> { PermissionServiceImpl(get()) }
    single<LocationService> { LocationServiceImpl() }
    single<LocaleService> { LocaleServiceImpl() }
}
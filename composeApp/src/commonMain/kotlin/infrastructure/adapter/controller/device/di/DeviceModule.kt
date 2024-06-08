package infrastructure.adapter.controller.device.di

import domain.adapter.device.LocaleService
import domain.adapter.device.LocationService
import domain.adapter.device.PermissionService
import infrastructure.adapter.controller.device.LocaleServiceImpl
import infrastructure.adapter.controller.device.LocationServiceImpl
import infrastructure.adapter.controller.device.PermissionServiceImpl
import org.koin.dsl.module

val deviceModule = module {
    single<PermissionService> { PermissionServiceImpl(get()) }
    single<LocationService> { LocationServiceImpl() }
    single<LocaleService> { LocaleServiceImpl() }
}
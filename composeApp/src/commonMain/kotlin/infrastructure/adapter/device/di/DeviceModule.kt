package infrastructure.adapter.device.di

import domain.adapter.device.LocaleService
import domain.adapter.device.LocationService
import domain.adapter.device.PermissionService
import infrastructure.adapter.device.LocaleServiceImpl
import infrastructure.adapter.device.LocationServiceImpl
import infrastructure.adapter.device.PermissionServiceImpl
import org.koin.dsl.module

val deviceModule = module {
    single<PermissionService> { PermissionServiceImpl(get()) }
    single<LocationService> { LocationServiceImpl() }
    single<LocaleService> { LocaleServiceImpl() }
}
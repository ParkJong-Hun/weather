package co.kr.parkjonghun.composemultiplatformtestairfield.uicore.utility.di

import co.kr.parkjonghun.composemultiplatformtestairfield.uicore.utility.PermissionUtility
import co.kr.parkjonghun.composemultiplatformtestairfield.uicore.utility.PermissionUtilityImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val utilityModule: Module = module {
    single<PermissionUtility> {
        PermissionUtilityImpl(
            requestPermissionUseCase = get(),
            checkPermissionUseCase = get(),
            isPermissionAvailableUseCase = get(),
            openAppSettingsUseCase = get(),
        )
    }
}
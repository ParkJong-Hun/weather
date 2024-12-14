package co.kr.parkjonghun.composemultiplatformairfield.shared.ui.utility.di

import co.kr.parkjonghun.composemultiplatformairfield.shared.ui.utility.PermissionUtility
import co.kr.parkjonghun.composemultiplatformairfield.shared.ui.utility.PermissionUtilityImpl
import org.koin.core.module.Module
import org.koin.dsl.module

internal val utilityModule: Module = module {
    single<PermissionUtility> {
        PermissionUtilityImpl(
            requestPermissionUseCase = get(),
            checkPermissionUseCase = get(),
            isPermissionAvailableUseCase = get(),
            openAppSettingsUseCase = get(),
        )
    }
}
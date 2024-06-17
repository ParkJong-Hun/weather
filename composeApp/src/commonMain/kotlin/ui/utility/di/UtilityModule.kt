package ui.utility.di

import org.koin.core.module.Module
import org.koin.dsl.module
import ui.utility.PermissionUtility
import ui.utility.PermissionUtilityImpl

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
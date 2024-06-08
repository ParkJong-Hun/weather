package infrastructure.ui.utility.di

import org.koin.core.module.Module
import org.koin.dsl.module
import infrastructure.ui.utility.PermissionUtility
import infrastructure.ui.utility.PermissionUtilityImpl

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
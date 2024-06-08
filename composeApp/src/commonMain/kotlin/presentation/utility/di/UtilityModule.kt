package presentation.utility.di

import org.koin.core.module.Module
import org.koin.dsl.module
import presentation.utility.PermissionUtility
import presentation.utility.PermissionUtilityImpl

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
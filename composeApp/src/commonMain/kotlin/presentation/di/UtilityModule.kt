package presentation.di

import org.koin.core.module.Module
import org.koin.dsl.module
import presentation.utility.PermissionUtility
import presentation.utility.PermissionUtilityImpl

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
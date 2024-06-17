package ui.utility

import domain.entity.Permission
import domain.entity.PermissionState
import domain.usecase.CheckPermissionUseCase
import domain.usecase.IsPermissionAvailableUseCase
import domain.usecase.OpenAppSettingsUseCase
import domain.usecase.RequestPermissionUseCase

interface PermissionUtility {
    suspend fun requestPermission(permission: Permission)
    suspend fun checkPermission(permission: Permission): PermissionState
    suspend fun isPermissionAvailable(permission: Permission): Boolean
    fun openAppSettings()
}

class PermissionUtilityImpl(
    private val requestPermissionUseCase: RequestPermissionUseCase,
    private val checkPermissionUseCase: CheckPermissionUseCase,
    private val isPermissionAvailableUseCase: IsPermissionAvailableUseCase,
    private val openAppSettingsUseCase: OpenAppSettingsUseCase,
) : PermissionUtility {
    override suspend fun requestPermission(permission: Permission) =
        requestPermissionUseCase(permission)

    override suspend fun checkPermission(permission: Permission): PermissionState =
        checkPermissionUseCase(permission)

    override suspend fun isPermissionAvailable(permission: Permission): Boolean =
        isPermissionAvailableUseCase(permission)

    override fun openAppSettings() = openAppSettingsUseCase()
}
package ui.utility

import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.CheckPermissionUseCase
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.IsPermissionAvailableUseCase
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.OpenAppSettingsUseCase
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.RequestPermissionUseCase
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.Permission
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.PermissionState

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
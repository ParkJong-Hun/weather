package domain.adapter.device

import domain.entity.Permission
import domain.entity.PermissionState

interface PermissionService {
    suspend fun requestPermission(permission: Permission)
    suspend fun checkPermission(permission: Permission): PermissionState
    suspend fun isPermissionAvailable(permission: Permission): Boolean
    fun openAppSettings()
}
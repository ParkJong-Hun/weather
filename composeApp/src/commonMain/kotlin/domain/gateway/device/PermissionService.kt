package domain.gateway.device

import domain.entity.Permission
import domain.entity.PermissionState

interface PermissionService {
    suspend fun requestPermission(permission: Permission)
    suspend fun checkPermission(permission: Permission): PermissionState
}
package co.kr.parkjonghun.composemultiplatformtestairfield.application.adapter.device

import co.kr.parkjonghun.composemultiplatformtestairfield.domain.Permission
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.PermissionState

interface PermissionService {
    suspend fun requestPermission(permission: Permission)
    suspend fun checkPermission(permission: Permission): PermissionState
    suspend fun isPermissionAvailable(permission: Permission): Boolean
    fun openAppSettings()
}
package co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase

import co.kr.parkjonghun.composemultiplatformtestairfield.application.adapter.device.PermissionService
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.Permission
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.PermissionState

interface CheckPermissionUseCase {
    suspend operator fun invoke(permission: Permission): PermissionState
}

class CheckPermissionUseCaseImpl(
    private val permissionService: PermissionService,
) : CheckPermissionUseCase {
    override suspend fun invoke(permission: Permission) =
        permissionService.checkPermission(permission)
}
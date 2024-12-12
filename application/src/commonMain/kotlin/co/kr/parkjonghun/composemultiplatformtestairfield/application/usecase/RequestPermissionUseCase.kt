package co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase

import co.kr.parkjonghun.composemultiplatformtestairfield.application.adapter.device.PermissionService
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.Permission

interface RequestPermissionUseCase {
    suspend operator fun invoke(permission: Permission)
}

class RequestPermissionUseCaseImpl(
    private val permissionService: PermissionService,
) : RequestPermissionUseCase {
    override suspend fun invoke(permission: Permission) =
        permissionService.requestPermission(permission)
}
package co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase

import co.kr.parkjonghun.composemultiplatformtestairfield.application.adapter.device.PermissionService
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.Permission

interface IsPermissionAvailableUseCase {
    suspend operator fun invoke(permission: Permission): Boolean
}

class IsPermissionAvailableUseCaseImpl(
    private val permissionService: PermissionService,
) : IsPermissionAvailableUseCase {
    override suspend fun invoke(permission: Permission) =
        permissionService.isPermissionAvailable(permission)
}
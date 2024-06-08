package domain.usecase

import domain.adapter.device.PermissionService
import domain.entity.Permission
import domain.entity.PermissionState

interface CheckPermissionUseCase {
    suspend operator fun invoke(permission: Permission): PermissionState
}

class CheckPermissionUseCaseImpl(
    private val permissionService: PermissionService,
) : CheckPermissionUseCase {
    override suspend fun invoke(permission: Permission) =
        permissionService.checkPermission(permission)
}
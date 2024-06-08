package domain.usecase

import domain.adapter.device.PermissionService
import domain.entity.Permission

interface RequestPermissionUseCase {
    suspend operator fun invoke(permission: Permission)
}

class RequestPermissionUseCaseImpl(
    private val permissionService: PermissionService,
) : RequestPermissionUseCase {
    override suspend fun invoke(permission: Permission) =
        permissionService.requestPermission(permission)
}
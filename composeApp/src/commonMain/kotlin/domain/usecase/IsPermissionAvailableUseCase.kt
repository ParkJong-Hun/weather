package domain.usecase

import domain.adapter.device.PermissionService
import domain.entity.Permission

interface IsPermissionAvailableUseCase {
    suspend operator fun invoke(permission: Permission): Boolean
}

class IsPermissionAvailableUseCaseImpl(
    private val permissionService: PermissionService,
) : IsPermissionAvailableUseCase {
    override suspend fun invoke(permission: Permission) =
        permissionService.isPermissionAvailable(permission)
}
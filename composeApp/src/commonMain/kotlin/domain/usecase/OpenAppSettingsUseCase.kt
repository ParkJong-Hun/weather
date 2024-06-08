package domain.usecase

import domain.adapter.device.PermissionService

interface OpenAppSettingsUseCase {
    operator fun invoke()
}

class OpenAppSettingsUseCaseImpl(
    private val permissionService: PermissionService,
) : OpenAppSettingsUseCase {
    override fun invoke() = permissionService.openAppSettings()
}
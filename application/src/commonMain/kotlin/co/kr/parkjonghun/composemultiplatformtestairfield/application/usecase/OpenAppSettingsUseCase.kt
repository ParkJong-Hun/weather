package co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase

import co.kr.parkjonghun.composemultiplatformtestairfield.application.adapter.device.PermissionService

interface OpenAppSettingsUseCase {
    operator fun invoke()
}

class OpenAppSettingsUseCaseImpl(
    private val permissionService: PermissionService,
) : OpenAppSettingsUseCase {
    override fun invoke() = permissionService.openAppSettings()
}
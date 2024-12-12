package infrastructure.adapter.controller.device

import co.kr.parkjonghun.composemultiplatformtestairfield.application.adapter.device.PermissionService
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.Permission
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.PermissionDeniedAlwaysException
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.PermissionDeniedException
import dev.icerock.moko.permissions.DeniedAlwaysException
import dev.icerock.moko.permissions.DeniedException
import dev.icerock.moko.permissions.PermissionsController
import infrastructure.adapter.mapper.asDataModel
import infrastructure.adapter.mapper.asEntity
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.Permission as DomainPermission
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.PermissionState as DomainPermissionState

class PermissionServiceImpl(
    private val permissionsController: PermissionsController
) : PermissionService {
    override suspend fun requestPermission(permission: DomainPermission) {
        try {
            permissionsController.providePermission(permission.asDataModel())
        } catch (deniedAlways: DeniedAlwaysException) {
            throw PermissionDeniedAlwaysException(permission)
        } catch (denied: DeniedException) {
            throw PermissionDeniedException(permission)
        }
    }

    override suspend fun checkPermission(permission: DomainPermission): DomainPermissionState {
        return permissionsController.getPermissionState(permission.asDataModel()).asEntity()
    }

    override suspend fun isPermissionAvailable(permission: Permission): Boolean {
        return permissionsController.isPermissionGranted(permission.asDataModel())
    }

    override fun openAppSettings() {
        permissionsController.openAppSettings()
    }
}
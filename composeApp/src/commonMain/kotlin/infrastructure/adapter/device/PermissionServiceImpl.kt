package infrastructure.adapter.device

import dev.icerock.moko.permissions.DeniedAlwaysException
import dev.icerock.moko.permissions.DeniedException
import dev.icerock.moko.permissions.PermissionsController
import domain.adapter.device.PermissionService
import domain.entity.Permission
import domain.entity.PermissionDeniedAlwaysException
import domain.entity.PermissionDeniedException
import infrastructure.adapter.mapper.asDataModel
import infrastructure.adapter.mapper.asEntity
import domain.entity.Permission as DomainPermission
import domain.entity.PermissionState as DomainPermissionState

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
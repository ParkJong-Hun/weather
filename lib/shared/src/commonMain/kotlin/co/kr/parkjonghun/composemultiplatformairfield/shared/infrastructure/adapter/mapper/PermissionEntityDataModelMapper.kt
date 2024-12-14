package co.kr.parkjonghun.composemultiplatformairfield.shared.infrastructure.adapter.mapper

import dev.icerock.moko.permissions.Permission
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.Permission as DomainPermission

object PermissionEntityDataModelMapper : EntityDataModelMapper<Permission, DomainPermission> {
    override fun toEntity(dataModel: Permission): DomainPermission {
        return when (dataModel) {
            Permission.LOCATION -> DomainPermission.LOCATION
            else -> throw IllegalArgumentException("Unknown permission")
        }
    }

    override fun toDataModel(entity: DomainPermission): Permission {
        return when (entity) {
            DomainPermission.LOCATION -> Permission.LOCATION
        }
    }
}

fun Permission.asEntity() = PermissionEntityDataModelMapper.toEntity(this)
fun DomainPermission.asDataModel() = PermissionEntityDataModelMapper.toDataModel(this)
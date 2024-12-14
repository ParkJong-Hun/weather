package co.kr.parkjonghun.composemultiplatformairfield.shared.infrastructure.adapter.mapper

import dev.icerock.moko.permissions.PermissionState
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.PermissionState as DomainPermissionState

object PermissionStateEntityMapper : EntityMapper<PermissionState, DomainPermissionState> {

    override fun toEntity(dataModel: PermissionState): DomainPermissionState {
        return when (dataModel) {
            // Both
            PermissionState.NotDetermined -> DomainPermissionState.NOT_YET
            // Only Android
            PermissionState.Denied -> DomainPermissionState.NOT_YET

            // Both(but Android only Push)
            PermissionState.DeniedAlways -> DomainPermissionState.UNAVAILABLE
            // Only Android
            PermissionState.NotGranted -> DomainPermissionState.UNAVAILABLE

            // Both
            PermissionState.Granted -> DomainPermissionState.AVAILABLE
        }
    }
}

fun PermissionState.asEntity() = PermissionStateEntityMapper.toEntity(this)
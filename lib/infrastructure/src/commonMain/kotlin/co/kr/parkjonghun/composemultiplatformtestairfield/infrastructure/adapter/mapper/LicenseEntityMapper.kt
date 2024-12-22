package co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.adapter.mapper

import co.kr.parkjonghun.composemultiplatformtestairfield.domain.LibraryLicense
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.LicenseInfo
import co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.adapter.controller.device.model.License
import co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.adapter.controller.device.model.SpdxLicense

object LicenseEntityMapper : EntityMapper<License, LibraryLicense> {

    override fun toEntity(dataModel: License): LibraryLicense {
        return dataModel.run {
            LibraryLicense(
                groupId = groupId,
                artifactId = artifactId,
                name = name,
                version = version,
                url = scm.url,
                licenses = spdxLicenses.map { it.asEntity() },
            )
        }
    }

    private fun SpdxLicense.asEntity() =
        LicenseInfo(
            identifier = identifier,
            name = name,
            url = url,
        )
}

fun License.asEntity() = LicenseEntityMapper.toEntity(this)
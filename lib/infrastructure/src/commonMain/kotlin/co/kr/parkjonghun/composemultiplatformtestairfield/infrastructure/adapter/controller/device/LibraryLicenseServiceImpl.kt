package co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.adapter.controller.device

import co.kr.parkjonghun.composemultiplatformtestairfield.application.adapter.device.LibraryLicenseService
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.LibraryLicense
import co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.adapter.mapper.asEntity

class LibraryLicenseServiceImpl : LibraryLicenseService {
    override suspend fun getLibraryLicenses(): Set<LibraryLicense> =
        getLicenseResource().map { it.asEntity() }.toSet()
}
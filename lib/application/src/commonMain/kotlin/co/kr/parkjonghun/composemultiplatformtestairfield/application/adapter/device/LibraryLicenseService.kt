package co.kr.parkjonghun.composemultiplatformtestairfield.application.adapter.device

import co.kr.parkjonghun.composemultiplatformtestairfield.domain.LibraryLicense

interface LibraryLicenseService {
    suspend fun getLibraryLicenses(): Set<LibraryLicense>
}

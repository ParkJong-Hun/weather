package co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase

import co.kr.parkjonghun.composemultiplatformtestairfield.application.adapter.device.LibraryLicenseService
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.LibraryLicense

interface GetLibraryLicensesUseCase {
    suspend operator fun invoke(): Set<LibraryLicense>
}

class GetLibraryLicensesUseCaseImpl(
    private val libraryLicenseService: LibraryLicenseService,
) : GetLibraryLicensesUseCase {
    override suspend fun invoke(): Set<LibraryLicense> {
        return libraryLicenseService.getLibraryLicenses()
    }
}
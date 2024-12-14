package co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase

import co.kr.parkjonghun.composemultiplatformtestairfield.application.adapter.device.LocationService
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.Coordinate
import kotlinx.coroutines.flow.Flow

interface GetCurrentLocationUseCase {
    suspend operator fun invoke(): Flow<Coordinate>
}

class GetCurrentLocationUseCaseImpl(
    private val locationService: LocationService,
) : GetCurrentLocationUseCase {
    override suspend operator fun invoke() = locationService.getCurrentLocation()
}
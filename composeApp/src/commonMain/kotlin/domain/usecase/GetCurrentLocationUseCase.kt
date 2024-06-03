package domain.usecase

import domain.entity.Coordinate
import domain.gateway.device.LocationService
import kotlinx.coroutines.flow.Flow

interface GetCurrentLocationUseCase {
    suspend operator fun invoke(): Flow<Coordinate>
}

class GetCurrentLocationUseCaseImpl(
    private val locationService: LocationService,
) : GetCurrentLocationUseCase {
    override suspend operator fun invoke() = locationService.getCurrentLocation()
}
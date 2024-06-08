package domain.usecase

import domain.adapter.device.LocationService
import domain.entity.Coordinate
import kotlinx.coroutines.flow.Flow

interface GetCurrentLocationUseCase {
    suspend operator fun invoke(): Flow<Coordinate>
}

class GetCurrentLocationUseCaseImpl(
    private val locationService: LocationService,
) : GetCurrentLocationUseCase {
    override suspend operator fun invoke() = locationService.getCurrentLocation()
}
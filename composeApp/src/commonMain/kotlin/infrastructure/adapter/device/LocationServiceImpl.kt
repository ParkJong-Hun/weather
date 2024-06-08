package infrastructure.adapter.device

import domain.entity.Coordinate
import domain.adapter.device.LocationService
import kotlinx.coroutines.flow.Flow
import infrastructure.adapter.device.getCurrentLocation as getCurrentLocationFlow

class LocationServiceImpl : LocationService {
    override suspend fun getCurrentLocation(): Flow<Coordinate> = getCurrentLocationFlow()
}
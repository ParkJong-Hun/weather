package infrastructure.device

import domain.entity.Coordinate
import domain.gateway.device.LocationService
import kotlinx.coroutines.flow.Flow
import infrastructure.device.getCurrentLocation as getCurrentLocationFlow

class LocationServiceImpl : LocationService {
    override suspend fun getCurrentLocation(): Flow<Coordinate> = getCurrentLocationFlow()
}
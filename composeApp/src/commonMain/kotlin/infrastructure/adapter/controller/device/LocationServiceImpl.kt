package infrastructure.adapter.controller.device

import domain.entity.Coordinate
import domain.adapter.device.LocationService
import kotlinx.coroutines.flow.Flow
import infrastructure.adapter.controller.device.getCurrentLocation as getCurrentLocationFlow

class LocationServiceImpl : LocationService {
    override suspend fun getCurrentLocation(): Flow<Coordinate> = getCurrentLocationFlow()
}
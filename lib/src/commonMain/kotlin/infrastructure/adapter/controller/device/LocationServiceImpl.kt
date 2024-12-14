package infrastructure.adapter.controller.device

import co.kr.parkjonghun.composemultiplatformtestairfield.application.adapter.device.LocationService
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.Coordinate
import kotlinx.coroutines.flow.Flow
import infrastructure.adapter.controller.device.getCurrentLocation as getCurrentLocationFlow

class LocationServiceImpl : LocationService {
    override suspend fun getCurrentLocation(): Flow<Coordinate> = getCurrentLocationFlow()
}
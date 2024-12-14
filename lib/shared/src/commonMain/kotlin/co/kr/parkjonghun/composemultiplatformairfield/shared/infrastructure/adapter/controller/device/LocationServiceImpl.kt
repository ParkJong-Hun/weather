package co.kr.parkjonghun.composemultiplatformairfield.shared.infrastructure.adapter.controller.device

import co.kr.parkjonghun.composemultiplatformtestairfield.application.adapter.device.LocationService
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.Coordinate
import kotlinx.coroutines.flow.Flow

class LocationServiceImpl : LocationService {
    override suspend fun getCurrentLocation(): Flow<Coordinate> = getCurrentLocation()
}
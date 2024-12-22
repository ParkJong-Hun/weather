package co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.adapter.controller.device

import co.kr.parkjonghun.composemultiplatformtestairfield.application.adapter.device.LocationService
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.GetCurrentLocationUseCase
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.Coordinate
import kotlinx.coroutines.flow.Flow

class LocationServiceImpl(
    private val getCurrentLocationUseCase: GetCurrentLocationUseCase
) : LocationService {
    override suspend fun getCurrentLocation(): Flow<Coordinate> = getCurrentLocationUseCase()
}
package co.kr.parkjonghun.composemultiplatformtestairfield.application.adapter.device

import co.kr.parkjonghun.composemultiplatformtestairfield.domain.Coordinate
import kotlinx.coroutines.flow.Flow

interface LocationService {
    suspend fun getCoordinate(): Flow<Coordinate>
}
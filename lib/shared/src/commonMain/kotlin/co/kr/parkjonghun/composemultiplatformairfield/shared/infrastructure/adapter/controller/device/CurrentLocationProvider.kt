package co.kr.parkjonghun.composemultiplatformairfield.shared.infrastructure.adapter.controller.device

import co.kr.parkjonghun.composemultiplatformtestairfield.domain.Coordinate
import kotlinx.coroutines.flow.Flow

expect fun getCurrentLocation(): Flow<Coordinate>
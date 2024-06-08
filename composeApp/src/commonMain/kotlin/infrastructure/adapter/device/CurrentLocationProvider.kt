package infrastructure.adapter.device

import domain.entity.Coordinate
import kotlinx.coroutines.flow.Flow

expect fun getCurrentLocation(): Flow<Coordinate>
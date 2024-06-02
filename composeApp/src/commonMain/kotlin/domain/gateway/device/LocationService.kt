package domain.gateway.device

import domain.entity.Coordinate

interface LocationService {
    fun getCurrentLocation(): Coordinate
}
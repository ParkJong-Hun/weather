package domain.gateway.platform

import domain.entity.City
import domain.entity.Coordinate

actual suspend fun getCurrentLocation(): Coordinate {
    // TODO: Implement
    return City.Tokyo.coordinate
}
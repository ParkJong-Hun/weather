package infrastructure.device

import domain.entity.City
import domain.entity.Coordinate
import domain.gateway.device.LocationService

class LocationServiceImpl : LocationService {
    // TODO
    override fun getCurrentLocation(): Coordinate {
        return City.Tokyo.coordinate
    }
}
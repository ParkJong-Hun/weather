package infrastructure.device

import LocationDelegate
import domain.entity.Coordinate
import inject
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import platform.CoreLocation.CLLocationManager
import platform.CoreLocation.kCLDistanceFilterNone
import platform.CoreLocation.kCLLocationAccuracyHundredMeters

actual fun getCurrentLocation(): Flow<Coordinate> = channelFlow {
    inject<CLLocationManager>().let {
        // Location Accuracy Setting
        it.desiredAccuracy = kCLLocationAccuracyHundredMeters
        // Distance Filter Setting
        it.distanceFilter = kCLDistanceFilterNone

        LocationDelegate(onLocationUpdate = (this::trySend))
            .also { delegate -> it.delegate = delegate }

        it.startUpdatingLocation()

        awaitClose { it.stopUpdatingLocation() }
    }
}
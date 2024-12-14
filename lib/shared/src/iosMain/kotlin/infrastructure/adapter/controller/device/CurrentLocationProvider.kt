package infrastructure.adapter.controller.device

import LocationDelegate
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.Coordinate
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import platform.CoreLocation.CLLocationManager
import platform.CoreLocation.kCLDistanceFilterNone
import platform.CoreLocation.kCLLocationAccuracyHundredMeters

private val clLocationManager = CLLocationManager().apply {
    // Location Accuracy Setting
    desiredAccuracy = kCLLocationAccuracyHundredMeters
    // Distance Filter Setting
    distanceFilter = kCLDistanceFilterNone
}

actual fun getCurrentLocation(): Flow<Coordinate> = channelFlow {
    clLocationManager.let {
        LocationDelegate(this::trySend).also { delegate -> it.delegate = delegate }
        it.startUpdatingLocation()
        awaitClose { it.stopUpdatingLocation() }
    }
}
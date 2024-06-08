package infrastructure.adapter.controller.device

import android.annotation.SuppressLint
import com.google.android.gms.location.FusedLocationProviderClient
import domain.entity.Coordinate
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import org.koin.java.KoinJavaComponent.inject

private const val DEFAULT_INTERVAL = 60 * 1000 * 10L

@SuppressLint("MissingPermission")
actual fun getCurrentLocation(): Flow<Coordinate> = channelFlow {
    val locationProvider: FusedLocationProviderClient by inject(FusedLocationProviderClient::class.java)
    while (true) {
        locationProvider.lastLocation
            .addOnSuccessListener { location ->
                trySend(Coordinate(location.latitude, location.longitude))
            }
            .addOnFailureListener {
                throw it
            }
        delay(DEFAULT_INTERVAL * 60)
    }
}
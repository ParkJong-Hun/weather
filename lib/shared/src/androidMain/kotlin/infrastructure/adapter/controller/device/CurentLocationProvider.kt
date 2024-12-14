package infrastructure.adapter.controller.device

import android.annotation.SuppressLint
import com.google.android.gms.location.CurrentLocationRequest
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.Granularity
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.CancellationToken
import com.google.android.gms.tasks.CancellationTokenSource
import com.google.android.gms.tasks.OnTokenCanceledListener
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.Coordinate
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import org.koin.java.KoinJavaComponent.inject

private const val DEFAULT_INTERVAL = 30 * 1000L

@SuppressLint("MissingPermission")
actual fun getCurrentLocation(): Flow<Coordinate> = channelFlow {
    val locationProvider: FusedLocationProviderClient by inject(FusedLocationProviderClient::class.java)
    while (true) {
        locationProvider.getCurrentLocation(
            CurrentLocationRequest.Builder()
                .setDurationMillis(DEFAULT_INTERVAL)
                .setMaxUpdateAgeMillis(DEFAULT_INTERVAL)
                .setGranularity(Granularity.GRANULARITY_PERMISSION_LEVEL)
                .setPriority(Priority.PRIORITY_HIGH_ACCURACY)
                .build(),
            object : CancellationToken() {
                override fun onCanceledRequested(p0: OnTokenCanceledListener): CancellationToken =
                    CancellationTokenSource().token

                override fun isCancellationRequested(): Boolean = false
            }
        ).addOnSuccessListener { location ->
            trySend(Coordinate(location.latitude, location.longitude))
        }.addOnFailureListener {
            throw it
        }
        delay(DEFAULT_INTERVAL)
    }
}
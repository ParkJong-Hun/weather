package co.kr.parkjonghun.composemultiplatformairfield.shared

import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dev.icerock.moko.permissions.PermissionsController
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val androidNativeDIContainer = module {
    single<PermissionsController> { PermissionsController(applicationContext = get()) }
    single<FusedLocationProviderClient> {
        LocationServices.getFusedLocationProviderClient(
            androidContext()
        )
    }
}
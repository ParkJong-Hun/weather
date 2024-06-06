import dev.icerock.moko.permissions.ios.PermissionsController
import org.koin.dsl.module
import platform.CoreLocation.CLLocationManager

val iosNativeDIContainer = module {
    single<PermissionsController> { PermissionsController() }
    single<CLLocationManager> { CLLocationManager() }
}
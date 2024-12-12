import co.kr.parkjonghun.composemultiplatformtestairfield.domain.Coordinate
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.GetLocationFailedException
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.useContents
import platform.CoreLocation.CLLocation
import platform.CoreLocation.CLLocationManager
import platform.CoreLocation.CLLocationManagerDelegateProtocol
import platform.Foundation.NSError
import platform.darwin.NSObject

@OptIn(ExperimentalForeignApi::class)
internal class LocationDelegate(
    private val onLocationUpdate: ((Coordinate) -> Unit),
) : NSObject(), CLLocationManagerDelegateProtocol {

    // Success
    override fun locationManager(
        manager: CLLocationManager,
        didUpdateLocations: List<*>,
    ) {
        didUpdateLocations.firstOrNull()?.let {
            (it as CLLocation).coordinate.useContents {
                onLocationUpdate(Coordinate(latitude, longitude))
            }
        }
    }

    // Fail
    override fun locationManager(
        manager: CLLocationManager,
        didFailWithError: NSError,
    ) {
        throw GetLocationFailedException(didFailWithError.localizedDescription())
    }
}
package domain.usecase

import domain.entity.Coordinate
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

interface GetDistanceUseCase {
    operator fun invoke(a: Coordinate, b: Coordinate): Double
}

class GetDistanceUseCaseImpl(
    private val getRadiansUseCase: GetRadiansUseCase,
) : GetDistanceUseCase {
    override fun invoke(a: Coordinate, b: Coordinate): Double {
        val lat1 = a.latitude
        val lon1 = a.longitude
        val lat2 = b.latitude
        val lon2 = b.longitude

        val dLat = getRadiansUseCase(lat2 - lat1)
        val dLon = getRadiansUseCase(lon2 - lon1)

        val haversineValue = sin(dLat / 2) * sin(dLat / 2) +
                cos(getRadiansUseCase(lat1)) * cos(getRadiansUseCase(lat2)) *
                sin(dLon / 2) * sin(dLon / 2)

        val centralAngle = 2 * atan2(sqrt(haversineValue), sqrt(1 - haversineValue))

        return R * centralAngle
    }

    companion object {
        // Earth radius (km)
        private const val R = 6371.0
    }
}

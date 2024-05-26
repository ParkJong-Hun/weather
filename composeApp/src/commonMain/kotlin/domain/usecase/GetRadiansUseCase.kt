package domain.usecase

import kotlin.math.PI

interface GetRadiansUseCase {
    operator fun invoke(degrees: Double): Double
}

class GetRadiansUseCaseImpl : GetRadiansUseCase {
    override fun invoke(degrees: Double): Double {
        return degrees * PI / 180
    }
}
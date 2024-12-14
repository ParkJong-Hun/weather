package co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase

import co.kr.parkjonghun.composemultiplatformtestairfield.domain.City
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.Coordinate

interface FindNearestCityCoordinateUseCase {
    operator fun invoke(coordinate: Coordinate): City
}

class FindNearestCityCoordinateUseCaseImpl(
    private val getDistanceUseCase: GetDistanceUseCase,
) : FindNearestCityCoordinateUseCase {
    override fun invoke(coordinate: Coordinate): City {
        return City.entries.minBy {
            getDistanceUseCase(coordinate, it.coordinate)
        }
    }
}
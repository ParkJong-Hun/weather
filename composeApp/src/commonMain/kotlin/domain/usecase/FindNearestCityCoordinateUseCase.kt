package domain.usecase

import domain.entity.City
import domain.entity.Coordinate

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
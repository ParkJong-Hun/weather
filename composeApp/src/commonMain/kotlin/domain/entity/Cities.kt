package domain.entity

// TODO
enum class Cities(val coordinate: Coordinate) {
    Tokyo(Coordinate(35.6895, 139.6917)),
    ;

    // FIXME
    fun findNearestCityByCoordinate(coordinate: Coordinate): Cities {
        return Tokyo
    }
}
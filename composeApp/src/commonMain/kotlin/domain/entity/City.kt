package domain.entity

enum class City(val cityName: String, val coordinate: Coordinate) {
    Tokyo(
        cityName = "Tokyo",
        coordinate = Coordinate(35.6895, 139.6917)
    ),
    Osaka(
        cityName = "Osaka",
        coordinate = Coordinate(34.6937, 135.5023)
    ),
    Yokohama(
        cityName = "Yokohama",
        coordinate = Coordinate(35.4437, 139.6380)
    ),
    Nagoya(
        cityName = "Nagoya",
        coordinate = Coordinate(35.1815, 136.9066)
    ),
    Sapporo(
        cityName = "Sapporo",
        coordinate = Coordinate(43.0618, 141.3545)
    ),
    Fukuoka(
        cityName = "Fukuoka",
        coordinate = Coordinate(33.5904, 130.4017)
    ),
    Okinawa(
        cityName = "Okinawa",
        coordinate = Coordinate(26.2124, 127.6809)
    ),
    Sendai(
        cityName = "Sendai",
        coordinate = Coordinate(38.2682, 140.8694)
    ),
    Hiroshima(
        cityName = "Hiroshima",
        coordinate = Coordinate(34.3853, 132.4553)
    ),
    Kyoto(
        cityName = "Kyoto",
        coordinate = Coordinate(35.0116, 135.7681)
    ),
    ;

    // FIXME
    fun findNearestCityByCoordinate(coordinate: Coordinate): City {
        return Tokyo
    }
}
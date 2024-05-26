package domain.entity

enum class City(val cityName: String, val japaneseCityName: String, val coordinate: Coordinate) {
    Tokyo(
        cityName = "Tokyo",
        japaneseCityName = "東京",
        coordinate = Coordinate(35.6895, 139.6917)
    ),
    Osaka(
        cityName = "Osaka",
        japaneseCityName = "大阪",
        coordinate = Coordinate(34.6937, 135.5023)
    ),
    Yokohama(
        cityName = "Yokohama",
        japaneseCityName = "横浜",
        coordinate = Coordinate(35.4437, 139.6380)
    ),
    Nagoya(
        cityName = "Nagoya",
        japaneseCityName = "名古屋",
        coordinate = Coordinate(35.1815, 136.9066)
    ),
    Sapporo(
        cityName = "Sapporo",
        japaneseCityName = "札幌",
        coordinate = Coordinate(43.0618, 141.3545)
    ),
    Fukuoka(
        cityName = "Fukuoka",
        japaneseCityName = "福岡",
        coordinate = Coordinate(33.5904, 130.4017)
    ),
    Okinawa(
        cityName = "Okinawa",
        japaneseCityName = "沖縄",
        coordinate = Coordinate(26.2124, 127.6809)
    ),
    Sendai(
        cityName = "Sendai",
        japaneseCityName = "仙台",
        coordinate = Coordinate(38.2682, 140.8694)
    ),
    Hiroshima(
        cityName = "Hiroshima",
        japaneseCityName = "広島",
        coordinate = Coordinate(34.3853, 132.4553)
    ),
    Kyoto(
        cityName = "Kyoto",
        japaneseCityName = "京都",
        coordinate = Coordinate(35.0116, 135.7681)
    ),
    ;
}
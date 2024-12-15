package co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.adapter.mapper.util

import co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.api.model.OpenWeatherResponseCoord
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.Coordinate

fun Coordinate.toFlattenString(): String {
    return "$latitude,$longitude"
}

fun Coordinate.toList(): List<Double> {
    return listOf(latitude, longitude)
}

fun List<Double>.toCoordinate(): Coordinate {
    return Coordinate(
        latitude = get(0),
        longitude = get(1),
    )
}

fun OpenWeatherResponseCoord.toEntity(): Coordinate {
    return Coordinate(
        latitude = lat,
        longitude = lon,
    )
}
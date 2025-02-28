package co.kr.parkjonghun.composemultiplatformtestairfield.feature.home.extension

fun String.toIntSafety(): Int =
    this.filter { it.isDigit() || it == '.' }.toDoubleOrNull()?.toInt() ?: 0

fun String.toDoubleSafety(): Double =
    this.filter { it.isDigit() || it == '.' }.toDoubleOrNull() ?: 0.0
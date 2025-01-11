package co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.key

import kotlinx.cinterop.ExperimentalForeignApi

actual typealias KeyPair = IosKeyPair

@OptIn(ExperimentalForeignApi::class)
class IosKeyPair(val secKeyRef: platform.Security.SecKeyRef)
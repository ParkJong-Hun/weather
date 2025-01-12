package co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.key

import kotlinx.cinterop.ExperimentalForeignApi

actual typealias KeyPair = IosKeyPair

@OptIn(ExperimentalForeignApi::class)
class IosKeyPair(
    val publicKey: platform.Security.SecKeyRef,
    val privateKey: platform.Security.SecKeyRef,
)
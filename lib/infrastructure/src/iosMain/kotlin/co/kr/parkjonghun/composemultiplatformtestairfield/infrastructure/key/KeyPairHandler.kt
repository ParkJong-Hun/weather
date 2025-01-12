package co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.key

import kotlinx.cinterop.ExperimentalForeignApi
import platform.Security.SecKeyGeneratePair

actual class KeyPairHandler {
    @OptIn(ExperimentalForeignApi::class)
    actual fun generateKeyPair(alias: String): KeyPair {
        SecKeyGeneratePair(
            parameters = TODO(),
            publicKey = TODO(),
            privateKey = TODO(),
        )
        return IosKeyPair(
            publicKey = TODO(),
            privateKey = TODO(),
        )
    }

    actual fun obtainKeyPair(alias: String): KeyPair? {
        TODO("Not yet implemented")
    }

    actual fun deleteKeyPair(alias: String): Boolean {
        TODO("Not yet implemented")
    }
}
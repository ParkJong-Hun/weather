package co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.key

actual class DigitalSignature(
    private val keyPairHandler: KeyPairHandler,
) {
    actual fun sign(
        alias: String,
        data: ByteArray
    ): PlatformBinaryData {
        TODO("Not yet implemented")
    }

    actual fun verify(alias: String, data: ByteArray): Boolean {
        TODO("Not yet implemented")
    }

    private fun hasKeyPair(alias: String): Boolean {
        return keyPairHandler.obtainKeyPair(alias) != null
    }

    private fun validateKey(alias: String): Boolean {
        // TODO
        return true
    }
}
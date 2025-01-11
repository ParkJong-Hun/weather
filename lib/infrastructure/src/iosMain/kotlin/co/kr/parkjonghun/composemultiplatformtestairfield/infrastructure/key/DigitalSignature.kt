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
}
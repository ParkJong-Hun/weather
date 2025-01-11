package co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.key

expect class DigitalSignature {
    fun sign(alias: String, data: ByteArray): PlatformBinaryData

    // When receiving data, it is always received as something like Ktor, so this is sufficient as [ByteArray].
    fun verify(alias: String, data: ByteArray): Boolean
}
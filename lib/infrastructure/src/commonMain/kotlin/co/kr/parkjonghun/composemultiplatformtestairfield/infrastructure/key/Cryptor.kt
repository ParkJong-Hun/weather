package co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.key

interface Cryptor {
    fun encrypt(byteArray: ByteArray): PlatformBinaryData

    // When receiving data, it is always received as something like Ktor, so this is sufficient as [ByteArray].
    fun decrypt(byteArray: ByteArray): ByteArray
}
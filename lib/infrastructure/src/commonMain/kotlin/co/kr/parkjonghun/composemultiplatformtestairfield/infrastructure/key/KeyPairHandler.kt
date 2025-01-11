package co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.key

expect class KeyPairHandler {
    fun generateKeyPair(alias: String): KeyPair
    fun obtainKeyPair(alias: String): KeyPair?
    fun deleteKeyPair(alias: String): Boolean
}
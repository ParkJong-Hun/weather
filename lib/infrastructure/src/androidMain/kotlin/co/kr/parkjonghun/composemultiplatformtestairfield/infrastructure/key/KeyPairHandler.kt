package co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.key

import android.annotation.SuppressLint
import android.security.keystore.KeyProperties
import java.security.KeyPairGenerator
import java.security.KeyStore
import java.security.PrivateKey

actual class KeyPairHandler {
    private val keyStore = KeyStore.getInstance(ANDROID_KEY_STORE).apply { load(null) }

    @SuppressLint("InlinedApi")
    actual fun generateKeyPair(alias: String): KeyPair {
        return KeyPairGenerator.getInstance(KeyProperties.KEY_ALGORITHM_RSA, ANDROID_KEY_STORE)
            .let {
                // TODO: Consider using KeyGenParameterSpec
                it.initialize(DEFAULT_KEY_SIZE)
                it.genKeyPair()
            }
    }

    actual fun obtainKeyPair(alias: String): KeyPair? {
        return with(keyStore) {
            if (containsAlias(alias)) {
                val publicKey = getCertificate(alias).publicKey
                val privateKey = getKey(alias, null) as PrivateKey
                KeyPair(
                    publicKey,
                    privateKey,
                )
            } else {
                null
            }
        }
    }

    actual fun deleteKeyPair(alias: String): Boolean {
        val result = runCatching { keyStore.deleteEntry(alias) }
        return result.isSuccess
    }

    companion object {
        private const val ANDROID_KEY_STORE = "AndroidKeyStore"
        private const val DEFAULT_KEY_SIZE = 2048
    }
}
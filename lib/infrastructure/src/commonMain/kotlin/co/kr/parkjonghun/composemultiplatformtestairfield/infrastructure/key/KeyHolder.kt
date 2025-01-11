package co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.key

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

interface KeyHolder {
    val keyAliases: StateFlow<Set<String>>
    fun insert(alias: String): Boolean
    fun delete(alias: String): Boolean
}

class KeyHolderImpl(
    private val keyPairHandler: KeyPairHandler,
) : KeyHolder {
    private val _keyAliases = MutableStateFlow<Set<String>>(setOf())
    override val keyAliases: StateFlow<Set<String>> = _keyAliases.asStateFlow()

    init {
        getPermanentKeyFromStore()
    }

    override fun insert(alias: String): Boolean {
        val result = runCatching { keyPairHandler.generateKeyPair(alias) }
        return if (result.isSuccess) {
            _keyAliases.value += alias
            true
        } else {
            false
        }
    }

    override fun delete(alias: String): Boolean {
        val result = runCatching { keyPairHandler.deleteKeyPair(alias) }
        return if (result.isSuccess) {
            _keyAliases.value -= alias
            true
        } else {
            false
        }
    }

    private fun getPermanentKeyFromStore() {
        // TODO: Retrieving keys stored in persistent storage
        // _keyAliases = dataStore.getPermanentKeys()
    }
}
package infrastructure.api

import infrastructure.model.DummyResponse

// FIXME: delete it.
interface DummyApi {
    fun getDummy(): DummyResponse
}

class DummyApiImpl : DummyApi {
    override fun getDummy(): DummyResponse {
        return DummyResponse()
    }
}
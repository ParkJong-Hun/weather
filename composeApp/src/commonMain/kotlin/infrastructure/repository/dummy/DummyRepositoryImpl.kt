package infrastructure.repository.dummy

import domain.gateway.repository.DummyRepository
import infrastructure.api.DummyApi
import infrastructure.mapper.asEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

// FIXME: delete it.
class DummyRepositoryImpl(
    private val dummyApi: DummyApi
) : DummyRepository {
    override fun fetchDummy() = flow {
        val dummyResponse = dummyApi.getDummy()
        val dummy = dummyResponse.asEntity()
        emit(dummy)
    }.flowOn(Dispatchers.IO)
}
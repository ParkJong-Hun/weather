package infrastructure.repository

import domain.entity.Dummy
import domain.gateway.repository.DummyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn

// FIXME: delete it.
class FakeDummyRepository : DummyRepository {
    override fun fetchDummy(): Flow<Dummy> {
        return flowOf(Dummy(dummy = "dummy")).flowOn(Dispatchers.IO)
    }
}
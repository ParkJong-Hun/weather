package domain.gateway.repository

import domain.entity.Dummy
import kotlinx.coroutines.flow.Flow

// FIXME: delete it.
interface DummyRepository {
    fun fetchDummy(): Flow<Dummy>
}
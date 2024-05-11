package infrastructure

import domain.gateway.repository.DummyRepository
import infrastructure.api.DummyApi

// FIXME: delete it.
class DummyRepositoryImpl(
    private val dummyApi: DummyApi
) : DummyRepository
package infrastructure

import domain.gateway.repository.DummyRepository

// FIXME: delete it.
class DummyRepositoryImpl(
    private val dummyRepository: DummyRepository
) : DummyRepository
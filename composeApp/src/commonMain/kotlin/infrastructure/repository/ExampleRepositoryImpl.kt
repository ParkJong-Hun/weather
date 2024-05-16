package infrastructure.repository

import domain.gateway.repository.ExampleRepository
import infrastructure.api.ExampleApi

class ExampleRepositoryImpl(
    private val exampleApi: ExampleApi,
) : ExampleRepository {
    override suspend fun getPerson(): String {
        return exampleApi.getPerson()
    }
}
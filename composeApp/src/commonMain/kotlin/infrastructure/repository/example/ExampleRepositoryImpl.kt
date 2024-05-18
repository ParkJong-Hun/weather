package infrastructure.repository.example

import domain.gateway.repository.ExampleRepository
import infrastructure.api.ExampleApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class ExampleRepositoryImpl(
    private val exampleApi: ExampleApi,
) : ExampleRepository {
    override suspend fun getPerson(): String {
        return withContext(Dispatchers.IO) {
            exampleApi.getPerson()
        }
    }
}
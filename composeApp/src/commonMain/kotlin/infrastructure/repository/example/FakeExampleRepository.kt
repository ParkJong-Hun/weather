package infrastructure.repository.example

import domain.gateway.repository.ExampleRepository

class FakeExampleRepository : ExampleRepository {
    override suspend fun getPerson(): String {
        return "john fake"
    }
}
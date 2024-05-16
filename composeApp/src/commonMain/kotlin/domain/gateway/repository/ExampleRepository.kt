package domain.gateway.repository

interface ExampleRepository {
    suspend fun getPerson(): String
}
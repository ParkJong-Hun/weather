package infrastructure.repository.mapper

interface EntityMapper<Response, Entity> {

    fun toEntity(response: Response): Entity
}
package infrastructure.mapper

interface EntityMapper<Response, Entity> {

    fun toEntity(response: Response): Entity
}
package infrastructure.mapper

import domain.entity.Dummy
import infrastructure.model.DummyResponse

// FIXME: delete it.
object DummyEntityMapper : EntityMapper<DummyResponse, Dummy> {
    override fun toEntity(response: DummyResponse): Dummy {
        return Dummy(
            dummy = response.dummy,
        )
    }
}

fun DummyResponse.asEntity() = DummyEntityMapper.toEntity(this)
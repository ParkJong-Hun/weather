package co.kr.parkjonghun.composemultiplatformairfield.shared.infrastructure.adapter.mapper

interface EntityMapper<DataModel, Entity> {

    fun toEntity(dataModel: DataModel): Entity
}

interface EntityDataModelMapper<DataModel, Entity> {

    fun toDataModel(entity: Entity): DataModel
    fun toEntity(dataModel: DataModel): Entity
}
package infrastructure.mapper

interface EntityMapper<DataModel, Entity> {

    fun toEntity(dataModel: DataModel): Entity
}

interface EntityDataModelMapper<DataModel, Entity> {

    fun toDataModel(entity: Entity): DataModel
    fun toEntity(dataModel: DataModel): Entity
}
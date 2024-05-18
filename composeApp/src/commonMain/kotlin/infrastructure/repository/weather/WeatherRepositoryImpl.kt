package infrastructure.repository.weather

import domain.entity.Coordinate
import domain.entity.WeatherInfo
import domain.gateway.repository.WeatherRepository
import infrastructure.api.WeatherApi
import infrastructure.mapper.asEntity
import infrastructure.mapper.util.toFlattenString
import infrastructure.model.WeatherRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class WeatherRepositoryImpl(
    private val weatherApi: WeatherApi,
) : WeatherRepository {
    override suspend fun getWeather(
        coordinate: Coordinate,
    ): Flow<WeatherInfo> = flow {
        val request = WeatherRequest(
            appId = APP_ID,
            coordinates = coordinate.toFlattenString(),
            output = JSON,
        )
        val response = weatherApi.getWeather(request)
        val entity = response.asEntity()
        emit(entity)
    }.flowOn(Dispatchers.IO)

    companion object {
        private const val APP_ID = "pjh_weather"
        private const val JSON = "json"
    }
}
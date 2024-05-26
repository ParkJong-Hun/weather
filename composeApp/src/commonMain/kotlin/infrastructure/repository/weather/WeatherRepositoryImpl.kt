package infrastructure.repository.weather

import domain.entity.City
import domain.entity.Coordinate
import domain.entity.WeatherSnapshot
import domain.gateway.repository.WeatherRepository
import infrastructure.api.OpenWeatherApi
import infrastructure.mapper.asEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class WeatherRepositoryImpl(
    private val openWeatherApi: OpenWeatherApi,
) : WeatherRepository {
    override fun getWeatherByCoordinate(coordinate: Coordinate): Flow<WeatherSnapshot> = flow {
        val response = openWeatherApi.getWeatherByCoordinate(
            lat = coordinate.latitude,
            lon = coordinate.longitude,
        )
        val entity = response.asEntity()
        emit(entity)
    }.flowOn(Dispatchers.IO)

    override fun getWeatherByCity(city: City): Flow<WeatherSnapshot> = flow {
        val response = openWeatherApi.getWeatherByCityName(
            cityName = city.cityName,
        )
        val entity = response.asEntity()
        emit(entity)
    }.flowOn(Dispatchers.IO)
}
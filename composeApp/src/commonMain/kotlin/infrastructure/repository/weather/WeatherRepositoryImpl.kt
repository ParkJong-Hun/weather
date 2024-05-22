package infrastructure.repository.weather

import domain.entity.City
import domain.entity.Coordinate
import domain.entity.WeatherInfo
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
    override fun getWeatherByCoordinate(coordinate: Coordinate): Flow<WeatherInfo> = flow {
        val response = openWeatherApi.getWeatherByCoordinate(
            lat = coordinate.latitude,
            lon = coordinate.longitude,
            appid = APP_ID,
        )
        val entity = response.asEntity()
        emit(entity)
    }.flowOn(Dispatchers.IO)

    override fun getWeatherByCity(city: City): Flow<WeatherInfo> = flow {
        val response = openWeatherApi.getWeatherByCityName(
            cityName = city.cityName,
            appid = APP_ID,
        )
        val entity = response.asEntity()
        emit(entity)
    }.flowOn(Dispatchers.IO)

    companion object {
        private const val APP_ID = "pjh_weather"
    }
}
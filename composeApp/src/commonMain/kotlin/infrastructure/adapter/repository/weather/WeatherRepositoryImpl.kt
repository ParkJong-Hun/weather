package infrastructure.adapter.repository.weather

import domain.entity.City
import domain.entity.Coordinate
import domain.entity.Locale
import domain.entity.WeatherSnapshot
import domain.adapter.repository.WeatherRepository
import domain.usecase.GetLocaleUseCase
import infrastructure.api.OpenWeatherApi
import infrastructure.adapter.mapper.asEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class WeatherRepositoryImpl(
    private val openWeatherApi: OpenWeatherApi,
    private val getLocaleUseCase: GetLocaleUseCase,
) : WeatherRepository {
    override fun getWeatherByCoordinate(coordinate: Coordinate): Flow<WeatherSnapshot> = flow {
        val response = openWeatherApi.getWeatherByCoordinate(
            lat = coordinate.latitude,
            lon = coordinate.longitude,
            lang = getLocaleUseCase().toApiLanguageCode(),
        )
        val entity = response.asEntity()
        emit(entity)
    }.flowOn(Dispatchers.IO)

    override fun getWeatherByCity(city: City): Flow<WeatherSnapshot> = flow {
        val response = openWeatherApi.getWeatherByCityName(
            cityName = city.cityName,
            lang = getLocaleUseCase().toApiLanguageCode(),
        )
        val entity = response.asEntity()
        emit(entity)
    }.flowOn(Dispatchers.IO)

    companion object {
        // I don't know why the language code is different from the domain.common language code.
        private fun Locale.toApiLanguageCode(): String = when (this) {
            Locale.JAPANESE -> "ja"
            Locale.ENGLISH -> "en"
            Locale.CHINESE -> "zh_cn"
            Locale.KOREAN -> "kr"
            Locale.UNKNOWN -> "en"
        }
    }
}
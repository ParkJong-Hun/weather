package co.kr.parkjonghun.composemultiplatformairfield.shared.infrastructure.adapter.gateway.repository.weather

import co.kr.parkjonghun.composemultiplatformairfield.shared.infrastructure.adapter.mapper.asEntity
import co.kr.parkjonghun.composemultiplatformairfield.shared.infrastructure.api.OpenWeatherApi
import co.kr.parkjonghun.composemultiplatformtestairfield.application.adapter.repository.WeatherRepository
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.GetLocaleUseCase
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.City
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.Coordinate
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.Locale
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.WeatherSnapshot
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
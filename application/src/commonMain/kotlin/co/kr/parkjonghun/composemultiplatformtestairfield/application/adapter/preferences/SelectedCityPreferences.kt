package co.kr.parkjonghun.composemultiplatformtestairfield.application.adapter.preferences

import co.kr.parkjonghun.composemultiplatformtestairfield.domain.City
import kotlinx.coroutines.flow.Flow

interface SelectedCityPreferences {
    fun getCityFlow(): Flow<City?>
    fun updateSelectedCity(city: City)
}
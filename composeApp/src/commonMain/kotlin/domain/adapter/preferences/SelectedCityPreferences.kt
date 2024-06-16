package domain.adapter.preferences

import domain.entity.City
import kotlinx.coroutines.flow.Flow

interface SelectedCityPreferences {
    fun getCityFlow(): Flow<City?>
    fun updateSelectedCity(city: City)
}
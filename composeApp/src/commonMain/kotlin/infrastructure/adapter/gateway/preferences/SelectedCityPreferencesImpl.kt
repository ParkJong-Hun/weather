package infrastructure.adapter.gateway.preferences

import com.russhwolf.settings.Settings
import com.russhwolf.settings.set
import domain.adapter.preferences.SelectedCityPreferences
import domain.entity.City
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SelectedCityPreferencesImpl(
    private val settings: Settings,
) : SelectedCityPreferences {
    private val stateFlow = MutableStateFlow(selectSelectedCity())

    override fun getCityFlow(): Flow<City?> = stateFlow.asStateFlow()

    override fun updateSelectedCity(city: City) {
        settings[SELECTED_CITY] = city.cityName
        stateFlow.value = selectSelectedCity()
    }

    private fun selectSelectedCity(): City? {
        return settings.getStringOrNull(SELECTED_CITY)?.let { City.findByCityName(it) }
    }

    companion object {
        private const val SELECTED_CITY = "SELECTED_CITY"
    }
}
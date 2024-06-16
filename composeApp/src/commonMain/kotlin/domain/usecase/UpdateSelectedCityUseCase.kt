package domain.usecase

import domain.adapter.preferences.SelectedCityPreferences
import domain.entity.City

interface UpdateSelectedCityUseCase {
    operator fun invoke(city: City)
}

class UpdateSelectedCityUseCaseImpl(
    private val preferences: SelectedCityPreferences,
) : UpdateSelectedCityUseCase {
    override fun invoke(city: City) {
        preferences.updateSelectedCity(city)
    }
}
package co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase

import co.kr.parkjonghun.composemultiplatformtestairfield.application.adapter.preferences.SelectedCityPreferences
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.City

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
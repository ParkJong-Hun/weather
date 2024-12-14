package co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase

import co.kr.parkjonghun.composemultiplatformtestairfield.application.adapter.preferences.SelectedCityPreferences
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.City
import kotlinx.coroutines.flow.Flow

interface GetSelectedCityUseCase {
    operator fun invoke(): Flow<City?>
}

class GetSelectedCityUseCaseImpl(
    private val preferences: SelectedCityPreferences,
) : GetSelectedCityUseCase {
    override fun invoke(): Flow<City?> = preferences.getCityFlow()
}
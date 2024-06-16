package domain.usecase

import domain.adapter.preferences.SelectedCityPreferences
import domain.entity.City
import kotlinx.coroutines.flow.Flow

interface GetSelectedCityUseCase {
    operator fun invoke(): Flow<City?>
}

class GetSelectedCityUseCaseImpl(
    private val preferences: SelectedCityPreferences,
) : GetSelectedCityUseCase {
    override fun invoke(): Flow<City?> = preferences.getCityFlow()
}
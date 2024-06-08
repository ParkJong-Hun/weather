package domain.usecase

import domain.adapter.repository.WeatherRepository
import domain.entity.WeatherSnapshot
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest


interface GetWeatherByCurrentLocationUseCase {
    suspend operator fun invoke(): Flow<WeatherSnapshot>
}

class GetWeatherByCurrentLocationUseCaseImpl(
    private val getCurrentLocationUseCase: GetCurrentLocationUseCase,
    private val weatherRepository: WeatherRepository,
) : GetWeatherByCurrentLocationUseCase {

    @OptIn(ExperimentalCoroutinesApi::class)
    override suspend operator fun invoke(): Flow<WeatherSnapshot> {
        return getCurrentLocationUseCase().flatMapLatest {
            weatherRepository.getWeatherByCoordinate(it)
        }
    }
}
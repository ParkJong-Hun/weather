package domain.usecase

import domain.entity.WeatherInfo
import domain.gateway.repository.WeatherRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest


interface GetWeatherByCurrentLocationUseCase {
    operator fun invoke(): Flow<WeatherInfo>
}

class GetWeatherByCurrentLocationUseCaseImpl(
    private val getCurrentLocationUseCase: GetCurrentLocationUseCase,
    private val weatherRepository: WeatherRepository,
) : GetWeatherByCurrentLocationUseCase {

    @OptIn(ExperimentalCoroutinesApi::class)
    override operator fun invoke(): Flow<WeatherInfo> {
        return getCurrentLocationUseCase().flatMapLatest {
            weatherRepository.getWeatherByCoordinate(it)
        }
    }
}
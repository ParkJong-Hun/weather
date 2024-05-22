package domain.usecase

import domain.entity.Coordinate
import domain.gateway.platform.getCurrentLocation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

interface GetCurrentLocationUseCase {
    operator fun invoke(): Flow<Coordinate>
}

class GetCurrentLocationUseCaseImpl : GetCurrentLocationUseCase {
    override operator fun invoke() = flow {
        while (true) {
            emit(getCurrentLocation())
            delay(DEFAULT_INTERVAL)
        }
    }.flowOn(Dispatchers.Default)

    companion object {
        private const val DEFAULT_INTERVAL = 5000L * 60
    }
}
import domain.gateway.repository.DummyRepository
import infrastructure.DummyRepositoryImpl
import infrastructure.api.DummyApi
import infrastructure.api.DummyApiImpl
import org.kodein.di.DI
import org.kodein.di.bindSingleton
import org.kodein.di.instance

val appDI = DI {
    bindSingleton<DummyApi> { DummyApiImpl() }
    bindSingleton<DummyRepository> { DummyRepositoryImpl(dummyApi = instance()) }
}
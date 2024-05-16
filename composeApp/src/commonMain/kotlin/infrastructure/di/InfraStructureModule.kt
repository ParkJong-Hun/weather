package infrastructure.di

import de.jensklingenberg.ktorfit.Ktorfit
import org.koin.core.qualifier.named
import org.koin.dsl.module

val infrastructureModule = module {
    includes(
        apiModule,
        repositoryModule,
    )
    single<Ktorfit>(qualifier = named("exampleKtorfit")) {
        Ktorfit.Builder().baseUrl("https://swapi.dev/api/").build()
    }
}
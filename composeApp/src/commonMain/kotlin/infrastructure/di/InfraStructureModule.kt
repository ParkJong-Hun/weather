package infrastructure.di

import de.jensklingenberg.ktorfit.Ktorfit
import org.koin.dsl.module

val infrastructureModule = module {
    includes(
        apiModule,
        repositoryModule,
    )
    single<Ktorfit>(qualifier = KtorfitConfig.Example.qualifier) {
        Ktorfit.Builder().baseUrl(KtorfitConfig.Example.baseUrl).build()
    }
//    single<Ktorfit>(qualifier = KtorfitConfig.YahooWeather.qualifier) {
//        Ktorfit.Builder().baseUrl(KtorfitConfig.YahooWeather.baseUrl).build()
//    }
    single<Ktorfit>(qualifier = KtorfitConfig.OpenWeather.qualifier) {
        Ktorfit.Builder().baseUrl(KtorfitConfig.OpenWeather.baseUrl).build()
    }
}
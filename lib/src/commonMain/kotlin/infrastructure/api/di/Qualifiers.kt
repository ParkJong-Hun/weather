package infrastructure.api.di

import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.named

internal enum class KtorfitConfig(val qualifier: Qualifier, val baseUrl: String) {
    OpenWeather(
        qualifier = named("openWeatherKtorfit"),
        baseUrl = "https://api.openweathermap.org/data/2.5/"
    )
    ;

    fun findByQualifierName(qualifierName: String): KtorfitConfig? {
        return entries.find { it.qualifier == named(qualifierName) }
    }
}
package infrastructure.adapter.gateway.preferences.di

import com.russhwolf.settings.Settings
import domain.adapter.preferences.SelectedCityPreferences
import infrastructure.adapter.gateway.preferences.SelectedCityPreferencesImpl
import org.koin.dsl.module

val preferencesModule = module {
    single<Settings> { Settings() }
    single<SelectedCityPreferences> { SelectedCityPreferencesImpl(get()) }
}
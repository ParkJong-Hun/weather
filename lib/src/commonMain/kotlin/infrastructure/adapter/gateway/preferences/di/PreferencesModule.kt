package infrastructure.adapter.gateway.preferences.di

import co.kr.parkjonghun.composemultiplatformtestairfield.application.adapter.preferences.SelectedCityPreferences
import com.russhwolf.settings.Settings
import infrastructure.adapter.gateway.preferences.SelectedCityPreferencesImpl
import org.koin.dsl.module

val preferencesModule = module {
    single<Settings> { Settings() }
    single<SelectedCityPreferences> { SelectedCityPreferencesImpl(get()) }
}
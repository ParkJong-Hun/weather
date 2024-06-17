package ui.di

import ui.navigation.AppNavigator
import ui.utility.di.utilityModule
import org.koin.dsl.module

val presentationModule = module {
    includes(
        viewModelModule,
        utilityModule,
    )
    single { AppNavigator() }
}
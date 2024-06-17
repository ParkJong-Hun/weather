package infrastructure.ui.di

import infrastructure.ui.navigation.AppNavigator
import infrastructure.ui.utility.di.utilityModule
import org.koin.dsl.module

val presentationModule = module {
    includes(
        viewModelModule,
        utilityModule,
    )
    single { AppNavigator() }
}
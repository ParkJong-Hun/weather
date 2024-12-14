package co.kr.parkjonghun.composemultiplatformairfield.shared.ui.di

import co.kr.parkjonghun.composemultiplatformairfield.shared.ui.navigation.AppNavigator
import co.kr.parkjonghun.composemultiplatformairfield.shared.ui.utility.di.utilityModule
import org.koin.dsl.module

val presentationModule = module {
    includes(
        viewModelModule,
        utilityModule,
    )
    single { AppNavigator() }
}
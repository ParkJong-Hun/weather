package co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui.di

import co.kr.parkjonghun.composemultiplatformtestairfield.uicore.navigation.AppNavigator
import co.kr.parkjonghun.composemultiplatformtestairfield.uicore.utility.di.utilityModule
import org.koin.dsl.module

val presentationModule = module {
    includes(
        viewModelModule,
        utilityModule,
    )
    single { AppNavigator() }
}
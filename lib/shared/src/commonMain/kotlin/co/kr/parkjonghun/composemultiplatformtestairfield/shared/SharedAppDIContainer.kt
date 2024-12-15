package co.kr.parkjonghun.composemultiplatformtestairfield.shared

import co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.di.infrastructureModule
import co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui.di.presentationModule
import co.kr.parkjonghun.composemultiplatformtestairfield.application.di.applicationModule
import org.koin.dsl.module

val sharedAppDIContainer = module {
    includes(
        infrastructureModule,
        applicationModule,
        presentationModule,
    )
}
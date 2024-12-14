package co.kr.parkjonghun.composemultiplatformairfield.shared

import co.kr.parkjonghun.composemultiplatformairfield.shared.infrastructure.di.infrastructureModule
import co.kr.parkjonghun.composemultiplatformairfield.shared.ui.di.presentationModule
import co.kr.parkjonghun.composemultiplatformtestairfield.application.di.applicationModule
import org.koin.dsl.module

val sharedAppDIContainer = module {
    includes(
        infrastructureModule,
        applicationModule,
        presentationModule,
    )
}
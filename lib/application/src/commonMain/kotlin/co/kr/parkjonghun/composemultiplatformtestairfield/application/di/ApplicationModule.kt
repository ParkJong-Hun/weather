package co.kr.parkjonghun.composemultiplatformtestairfield.application.di

import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.di.useCaseModule
import org.koin.dsl.module

val applicationModule = module {
    includes(
        useCaseModule,
    )
}
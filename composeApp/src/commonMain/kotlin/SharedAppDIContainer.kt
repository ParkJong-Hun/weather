
import co.kr.parkjonghun.composemultiplatformtestairfield.application.di.applicationModule
import infrastructure.di.infrastructureModule
import org.koin.dsl.module
import ui.di.presentationModule

val sharedAppDIContainer = module {
    includes(
        infrastructureModule,
        applicationModule,
        presentationModule,
    )
}
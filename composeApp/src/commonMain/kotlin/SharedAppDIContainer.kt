import domain.usecase.di.domainModule
import infrastructure.di.infrastructureModule
import org.koin.dsl.module
import infrastructure.ui.di.presentationModule

val sharedAppDIContainer = module {
    includes(
        infrastructureModule,
        domainModule,
        presentationModule,
    )
}
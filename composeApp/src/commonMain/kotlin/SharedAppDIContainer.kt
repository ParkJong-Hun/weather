import domain.usecase.di.domainModule
import infrastructure.di.infrastructureModule
import org.koin.dsl.module
import presentation.di.presentationModule

val sharedAppDIContainer = module {
    includes(
        infrastructureModule,
        domainModule,
        presentationModule,
    )
}
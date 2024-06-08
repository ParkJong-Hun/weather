package infrastructure.ui.di

import org.koin.dsl.module
import infrastructure.ui.utility.di.utilityModule

val presentationModule = module {
    includes(
        viewModelModule,
        utilityModule,
    )
}
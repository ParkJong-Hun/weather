package presentation.di

import org.koin.dsl.module
import presentation.utility.di.utilityModule

val presentationModule = module {
    includes(
        viewModelModule,
        utilityModule,
    )
}
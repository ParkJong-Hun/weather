package presentation.di

import org.koin.dsl.module

val presentationModule = module {
    includes(
        viewModelModule,
        utilityModule,
    )
}
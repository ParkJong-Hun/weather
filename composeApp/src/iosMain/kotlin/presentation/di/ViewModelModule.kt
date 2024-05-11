package presentation.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import presentation.AppViewModel

actual val viewModelModule = module {
    singleOf(::AppViewModel)
}
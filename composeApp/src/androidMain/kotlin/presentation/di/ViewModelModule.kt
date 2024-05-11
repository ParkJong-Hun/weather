package presentation.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import presentation.AppViewModel

actual val viewModelModule = module {
    viewModelOf(::AppViewModel)
}
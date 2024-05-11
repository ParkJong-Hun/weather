package presentation.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import presentation.AppViewModel
import presentation.pages.home.HomeViewModel
import presentation.pages.search.SearchViewModel

actual val viewModelModule = module {
    viewModelOf(::AppViewModel)
    viewModelOf(::HomeViewModel)
    viewModelOf(::SearchViewModel)
}
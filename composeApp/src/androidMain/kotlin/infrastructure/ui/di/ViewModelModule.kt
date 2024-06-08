package infrastructure.ui.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import infrastructure.ui.AppViewModel
import infrastructure.ui.pages.home.HomeViewModel
import infrastructure.ui.pages.search.SearchViewModel

actual val viewModelModule = module {
    viewModelOf(::AppViewModel)
    viewModelOf(::HomeViewModel)
    viewModelOf(::SearchViewModel)
}
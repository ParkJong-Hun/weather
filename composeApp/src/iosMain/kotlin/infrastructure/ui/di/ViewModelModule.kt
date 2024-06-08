package infrastructure.ui.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import infrastructure.ui.AppViewModel
import infrastructure.ui.pages.home.HomeViewModel
import infrastructure.ui.pages.search.SearchViewModel

actual val viewModelModule = module {
    singleOf(::AppViewModel)
    singleOf(::HomeViewModel)
    singleOf(::SearchViewModel)
}
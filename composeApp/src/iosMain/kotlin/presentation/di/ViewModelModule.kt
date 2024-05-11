package presentation.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import presentation.AppViewModel
import presentation.pages.home.HomeViewModel
import presentation.pages.search.SearchViewModel

actual val viewModelModule = module {
    singleOf(::AppViewModel)
    singleOf(::HomeViewModel)
    singleOf(::SearchViewModel)
}
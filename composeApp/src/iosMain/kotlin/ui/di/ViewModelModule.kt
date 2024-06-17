package ui.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ui.AppViewModel
import ui.pages.home.HomeViewModel
import ui.pages.search.SearchViewModel

actual val viewModelModule = module {
    singleOf(::AppViewModel)
    singleOf(::HomeViewModel)
    singleOf(::SearchViewModel)
}
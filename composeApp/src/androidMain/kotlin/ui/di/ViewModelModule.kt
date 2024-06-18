package ui.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import ui.AppViewModel
import ui.pages.home.HomeViewModel
import ui.pages.search.SearchViewModel
import ui.pages.search.components.molecule.CityCellViewModel

actual val viewModelModule = module {
    viewModelOf(::AppViewModel)
    viewModelOf(::HomeViewModel)
    viewModelOf(::SearchViewModel)
    viewModelOf(::CityCellViewModel)
}
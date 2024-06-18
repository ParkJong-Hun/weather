package ui.di

import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ui.AppViewModel
import ui.pages.home.HomeViewModel
import ui.pages.search.SearchViewModel
import ui.pages.search.components.molecule.CityCellViewModel

actual val viewModelModule = module {
    singleOf(::AppViewModel)
    factoryOf(::HomeViewModel)
    factoryOf(::SearchViewModel)
    factoryOf(::CityCellViewModel)
}
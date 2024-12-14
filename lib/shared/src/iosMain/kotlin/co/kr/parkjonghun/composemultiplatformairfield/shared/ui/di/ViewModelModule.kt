package co.kr.parkjonghun.composemultiplatformairfield.shared.ui.di

import co.kr.parkjonghun.composemultiplatformairfield.shared.ui.AppViewModel
import co.kr.parkjonghun.composemultiplatformairfield.shared.ui.pages.home.HomeViewModel
import co.kr.parkjonghun.composemultiplatformairfield.shared.ui.pages.search.SearchViewModel
import co.kr.parkjonghun.composemultiplatformairfield.shared.ui.pages.search.components.molecule.CityCellViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val viewModelModule = module {
    singleOf(::AppViewModel)
    factoryOf(::HomeViewModel)
    factoryOf(::SearchViewModel)
    factoryOf(::CityCellViewModel)
}
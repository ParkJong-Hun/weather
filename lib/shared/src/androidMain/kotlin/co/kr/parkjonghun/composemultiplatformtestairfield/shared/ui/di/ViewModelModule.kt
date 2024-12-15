package co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui.di

import co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui.AppViewModel
import co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui.pages.home.HomeViewModel
import co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui.pages.search.SearchViewModel
import co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui.pages.search.components.molecule.CityCellViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

actual val viewModelModule = module {
    viewModelOf(::AppViewModel)
    viewModelOf(::HomeViewModel)
    viewModelOf(::SearchViewModel)
    viewModelOf(::CityCellViewModel)
}
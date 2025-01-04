package co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui.di

import co.kr.parkjonghun.composemultiplatformtestairfield.feature.home.home.HomeViewModel
import co.kr.parkjonghun.composemultiplatformtestairfield.feature.home.search.SearchViewModel
import co.kr.parkjonghun.composemultiplatformtestairfield.feature.home.search.components.molecule.CityCellViewModel
import co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui.AppViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

actual val viewModelModule = module {
    viewModelOf(::AppViewModel)
    viewModelOf(::HomeViewModel)
    viewModelOf(::SearchViewModel)
    viewModelOf(::CityCellViewModel)
}
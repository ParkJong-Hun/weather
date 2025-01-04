package co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui.di

import co.kr.parkjonghun.composemultiplatformtestairfield.feature.home.home.HomeViewModel
import co.kr.parkjonghun.composemultiplatformtestairfield.feature.home.search.SearchViewModel
import co.kr.parkjonghun.composemultiplatformtestairfield.feature.home.search.components.molecule.CityCellViewModel
import co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui.AppViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val viewModelModule = module {
    singleOf(::AppViewModel)
    factoryOf(::HomeViewModel)
    factoryOf(::SearchViewModel)
    factoryOf(::CityCellViewModel)
}
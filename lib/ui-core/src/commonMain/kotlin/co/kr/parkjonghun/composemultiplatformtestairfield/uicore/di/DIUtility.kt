package co.kr.parkjonghun.composemultiplatformtestairfield.uicore.di

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import org.koin.compose.currentKoinScope
import org.koin.core.parameter.ParametersDefinition

@Composable
inline fun <reified T : ViewModel> koinViewModel(
    key: String? = null,
    noinline parameters: ParametersDefinition? = null,
): T {
    val scope = currentKoinScope()
    return viewModel(key = key) {
        scope.get<T>(parameters = parameters)
    }
}
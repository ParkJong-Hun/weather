package co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.kr.parkjonghun.composemultiplatformtestairfield.feature.home.extension.DEFAULT_STOP_TIME_OUT_MILLIS
import co.kr.parkjonghun.composemultiplatformtestairfield.uicore.navigation.AppPages
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

interface AppViewModelInput

interface AppViewModelOutput {
    val uiState: StateFlow<AppUiState>
}

@Immutable
data class AppUiState(
    val text: String = "",
) {
    val startDestinationRoute = defaultRoute

    private companion object {
        val defaultRoute = AppPages.Home
    }
}

// State Holder
class AppViewModel : ViewModel(),
    AppViewModelInput,
    AppViewModelOutput {
    private val dummy: Flow<String> = flow {
        emit("a")
    }

    override val uiState: StateFlow<AppUiState> = combine(
        dummy,
    ) { text ->
        AppUiState(
            text = text.last(),
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(DEFAULT_STOP_TIME_OUT_MILLIS),
        initialValue = AppUiState(),
    )
}
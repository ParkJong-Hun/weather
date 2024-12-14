package ui

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ui.navigation.AppPages
import ui.pages.extension.DEFAULT_STOP_TIME_OUT_MILLIS
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
    val startDestinationRoute: String = defaultRoute

    private companion object {
        val defaultRoute = AppPages.Home.route
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
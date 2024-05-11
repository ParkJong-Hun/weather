package presentation.pages.home

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import common.DEFAULT_STOP_TIME_OUT_MILLIS
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

interface HomeViewModelInput

interface HomeViewModelOutput {
    val uiState: StateFlow<HomeUiState>
}

@Stable
data class HomeUiState(
    val isLoading: Boolean = false,
    val isError: Pair<Boolean, String?> = false to null,
)

class HomeViewModel(
) : ViewModel(),
    HomeViewModelInput,
    HomeViewModelOutput {
    private val dummy = MutableStateFlow("dummy")

    override val uiState: StateFlow<HomeUiState> = combine(
        dummy,
    ) { a ->
        HomeUiState(
            isLoading = a.last().isEmpty(),
            isError = false to null,
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(DEFAULT_STOP_TIME_OUT_MILLIS),
        initialValue = HomeUiState(),
    )
}
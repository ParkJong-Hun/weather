package presentation.pages.search

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import presentation.pages.extension.DEFAULT_STOP_TIME_OUT_MILLIS
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

interface SearchViewModelInput

interface SearchViewModelOutput {
    val uiState: StateFlow<SearchUiState>
}

@Stable
data class SearchUiState(
    val isLoading: Boolean = false,
    val isError: Pair<Boolean, String?> = false to null,
)

class SearchViewModel : ViewModel(),
    SearchViewModelInput,
    SearchViewModelOutput {
    private val dummy = MutableStateFlow("dummy")

    override val uiState: StateFlow<SearchUiState> = combine(
        dummy,
    ) { a ->
        SearchUiState(
            isLoading = a.last().isEmpty(),
            isError = false to null,
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(DEFAULT_STOP_TIME_OUT_MILLIS),
        initialValue = SearchUiState(),
    )
}
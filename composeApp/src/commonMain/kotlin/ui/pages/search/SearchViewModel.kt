package ui.pages.search

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.UpdateSelectedCityUseCase
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.City
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import ui.pages.extension.DEFAULT_STOP_TIME_OUT_MILLIS

interface SearchViewModelInput {
    fun onClickCity(city: City)
    fun onClickDialogOkButton()
}

interface SearchViewModelOutput {
    val uiState: StateFlow<SearchUiState>
}

@Immutable
data class SearchUiState(
    val isLoading: Boolean = false,
    val isShowDialog: Boolean = false,
    val dialogTitle: String? = null,
    val dialogMessage: String? = null,
    val isComplete: Boolean = false,
)

class SearchViewModel(
    private val updateSelectedCityUseCase: UpdateSelectedCityUseCase,
) : ViewModel(),
    SearchViewModelInput,
    SearchViewModelOutput {
    private val isLoading = MutableStateFlow(false)
    private val error = MutableStateFlow<Throwable?>(null)
    private val done = MutableStateFlow(false)

    override val uiState: StateFlow<SearchUiState> = combine(
        isLoading,
        error,
        done,
    ) { loading, error, done ->
        SearchUiState(
            isLoading = loading,
            isShowDialog = error != null,
            dialogTitle = if (error != null) "Store Error" else null,
            dialogMessage = if (error != null) "Please try again." else null,
            isComplete = done,
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(DEFAULT_STOP_TIME_OUT_MILLIS),
        initialValue = SearchUiState(),
    )

    override fun onClickCity(city: City) {
        runCatching {
            isLoading.value = true
            updateSelectedCityUseCase(city)
        }.onSuccess {
            isLoading.value = false
            done.value = true
        }.onFailure {
            isLoading.value = true
            error.value = it
        }
    }

    override fun onClickDialogOkButton() {
        error.value = null
    }
}
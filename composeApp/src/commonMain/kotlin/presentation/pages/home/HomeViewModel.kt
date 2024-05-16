package presentation.pages.home

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import common.DEFAULT_STOP_TIME_OUT_MILLIS
import domain.gateway.repository.ExampleRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

interface HomeViewModelInput {
    fun onClickExampleButton()
}

interface HomeViewModelOutput {
    val uiState: StateFlow<HomeUiState>
}

@Stable
data class HomeUiState(
    val person: String = "",
    val isLoading: Boolean = false,
    val isError: Pair<Boolean, String?> = false to null,
)

class HomeViewModel(
    private val exampleRepository: ExampleRepository,
) : ViewModel(),
    HomeViewModelInput,
    HomeViewModelOutput {
    private val dummy = MutableStateFlow("dummy")
    private val person = MutableStateFlow("")

    override val uiState: StateFlow<HomeUiState> = combine(
        dummy,
        person,
    ) { dummy, person ->
        HomeUiState(
            person = person,
            isLoading = dummy.isEmpty(),
            isError = false to null,
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(DEFAULT_STOP_TIME_OUT_MILLIS),
        initialValue = HomeUiState(),
    )

    override fun onClickExampleButton() {
        viewModelScope.launch {
            runCatching {
                exampleRepository.getPerson()
            }.onSuccess {
                person.value = it
            }.onFailure {
                person.value = it.message ?: "Unknown error"
            }
        }
    }
}
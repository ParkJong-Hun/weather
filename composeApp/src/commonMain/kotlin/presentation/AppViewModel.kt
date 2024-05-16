package presentation

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import common.DEFAULT_STOP_TIME_OUT_MILLIS
import domain.gateway.repository.DummyRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.stateIn
import presentation.navigation.AppPages

interface AppViewModelInput

interface AppViewModelOutput {
    val uiState: StateFlow<AppUiState>
}

@Stable
data class AppUiState(
    val text: String = "",
) {
    val startDestinationRoute: String = defaultRoute

    private companion object {
        val defaultRoute = AppPages.Home.route
    }
}

// State Holder
class AppViewModel(
    private val dummyRepository: DummyRepository,
) : ViewModel(),
    AppViewModelInput,
    AppViewModelOutput {
    @OptIn(ExperimentalCoroutinesApi::class)
    private val text = dummyRepository.fetchDummy()
        .mapLatest { it.dummy.toUpperCase() }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(DEFAULT_STOP_TIME_OUT_MILLIS),
            initialValue = "",
        )

    override val uiState: StateFlow<AppUiState> = combine(
        text,
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
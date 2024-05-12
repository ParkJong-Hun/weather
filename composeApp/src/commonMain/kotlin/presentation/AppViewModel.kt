package presentation

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import common.DEFAULT_STOP_TIME_OUT_MILLIS
import domain.gateway.repository.DummyRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.stateIn
import presentation.navigation.AppPages

interface AppViewModelInput {
    fun navigateToSearch()
    fun popBackStack()
}

interface AppViewModelOutput {
    val uiState: StateFlow<AppUiState>
}

@Stable
data class AppUiState(
    val text: String = "",
    val currentPageRoute: String = defaultRoute,
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

    private val currentPage = MutableStateFlow<AppPages>(AppPages.Home)

    override val uiState: StateFlow<AppUiState> = combine(
        text,
        currentPage,
    ) { text, currentPage ->
        AppUiState(
            text = text,
            currentPageRoute = currentPage.route,
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(DEFAULT_STOP_TIME_OUT_MILLIS),
        initialValue = AppUiState(),
    )

    override fun navigateToSearch() {
        currentPage.value = AppPages.Search
    }

    override fun popBackStack() {
        currentPage.value = AppPages.Home
    }
}
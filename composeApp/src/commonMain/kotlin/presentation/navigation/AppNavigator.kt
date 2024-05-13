package presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged

val LocalNavigator: ProvidableCompositionLocal<AppNavigator> =
    compositionLocalOf { error("No Navigator provided in the composition hierarchy. Make sure to provide a Navigator.") }

val currentNavigator: AppNavigator
    @Composable
    @ReadOnlyComposable
    get() = LocalNavigator.current


class AppNavigator {
    private val appNavHostController = MutableStateFlow<NavHostController?>(null)

    private val navigateEvents =
        MutableSharedFlow<NavigateEvent>(extraBufferCapacity = Int.MAX_VALUE)

    fun emitEvent(event: NavigateEvent) {
        navigateEvents.tryEmit(event)
    }

    suspend fun handleEvents(navHostController: NavHostController) {
        navHostController.init()
        navigateEvents
            .distinctUntilChanged()
            .collect { event ->
                when (event) {
                    is NavigateEvent.NavigateTo -> {
                        appNavHostController.value?.navigate(event.page.route)
                            ?: error("NavHostController is not initialized.")
                    }

                    is NavigateEvent.PopBackStack -> {
                        appNavHostController.value?.popBackStack()
                            ?: error("NavHostController is not initialized.")
                    }
                }
            }
    }

    private fun NavHostController.init() {
        if (appNavHostController.value == null) {
            appNavHostController.value = this
        }
    }
}

sealed class NavigateEvent {
    data class NavigateTo(val page: AppPages) : NavigateEvent()
    data object PopBackStack : NavigateEvent()
}
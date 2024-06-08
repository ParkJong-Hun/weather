package infrastructure.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import infrastructure.ui.di.koinViewModel
import infrastructure.ui.navigation.AppNavigator
import infrastructure.ui.navigation.AppPages
import infrastructure.ui.pages.home.HomePage
import infrastructure.ui.pages.search.SearchPage
import org.koin.compose.KoinContext

@Composable
fun App(appNavigator: AppNavigator) {
    AppTheme {
        KoinContext {
            val appNavHostController = rememberNavController()
            val appViewModel: AppViewModel = koinViewModel()
            val state by appViewModel.uiState.collectAsState()

            LaunchedEffect(Unit) {
                appNavigator.handleEvents(appNavHostController)
            }

            SideEffect {
                state.text
            }

            NavHost(
                navController = appNavHostController,
                startDestination = state.startDestinationRoute,
            ) {
                appNavigation()
            }
        }
    }
}

// TODO use type safety navArgs
private fun NavGraphBuilder.appNavigation() {
    composable(AppPages.Home.route) {
        HomePage()
    }

    composable(AppPages.Search.route) {
        SearchPage()
    }
}
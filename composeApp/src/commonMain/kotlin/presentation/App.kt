package presentation

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.koin.compose.KoinContext
import presentation.di.koinViewModel
import presentation.navigation.AppPages
import presentation.pages.home.HomePage
import presentation.pages.search.SearchPage

@Composable
fun App() {
    MaterialTheme {
        KoinContext {
            val navHostController = rememberNavController()
            val appViewModel: AppViewModel = koinViewModel()
            val state by appViewModel.uiState.collectAsState()

            SideEffect {
                state.text
            }

            NavHost(
                navController = navHostController,
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
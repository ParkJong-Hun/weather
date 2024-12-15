package co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui.di.koinViewModel
import co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui.navigation.AppPages
import co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui.navigation.currentNavigator
import co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui.pages.home.HomePage
import co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui.pages.search.SearchPage

@Composable
fun App() {
    AppTheme {
        val appNavHostController = rememberNavController()
        val appViewModel: AppViewModel = koinViewModel()
        val state by appViewModel.uiState.collectAsState()

        val appNavigator = currentNavigator

        LaunchedEffect(Unit) {
            appNavigator.handleEvents(appNavHostController)
        }

        NavHost(
            navController = appNavHostController,
            startDestination = state.startDestinationRoute,
        ) {
            appNavigation()
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
package co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.kr.parkjonghun.composemultiplatformtestairfield.feature.home.home.HomePage
import co.kr.parkjonghun.composemultiplatformtestairfield.feature.home.search.SearchPage
import co.kr.parkjonghun.composemultiplatformtestairfield.feature.license.license.LicensePage
import co.kr.parkjonghun.composemultiplatformtestairfield.uicore.di.koinViewModel
import co.kr.parkjonghun.composemultiplatformtestairfield.uicore.navigation.AppDeepLinks
import co.kr.parkjonghun.composemultiplatformtestairfield.uicore.navigation.AppPages
import co.kr.parkjonghun.composemultiplatformtestairfield.uicore.navigation.composablePush
import co.kr.parkjonghun.composemultiplatformtestairfield.uicore.navigation.currentNavigator
import org.jetbrains.compose.reload.DevelopmentEntryPoint

@Composable
fun App() {
    DevelopmentEntryPoint {
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
}

private fun NavGraphBuilder.appNavigation() {
    composable<AppPages.Home>(
        deepLinks = listOf(AppDeepLinks.Home.deepLink),
    ) {
        HomePage()
    }

    composablePush<AppPages.Search> {
        SearchPage()
    }

    composablePush<AppPages.License> {
        LicensePage()
    }
}
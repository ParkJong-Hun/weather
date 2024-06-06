package presentation.pages.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import domain.entity.City
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.components.template.CommonOkDialog
import presentation.di.koinViewModel
import presentation.pages.home.components.organism.AdditionalInfoCard
import presentation.pages.home.components.organism.MainInfo
import presentation.pages.home.components.organism.Title

// TODO use SharedTransitionScope
@Composable
fun NavGraphBuilder.HomePage(
    homeViewModel: HomeViewModel = koinViewModel(),
) {
    val state by homeViewModel.uiState.collectAsState()
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        HomePageBody(
            state = state,
            onClickSetting = homeViewModel::onClickCity,
            onClickCurrentLocation = homeViewModel::onClickCurrentLocation,
        )
        if (state.isShowDialog) {
            CommonOkDialog(
                title = state.dialogTitle!!,
                message = state.dialogMessage!!,
                onDismiss = homeViewModel::onClickDialogOkButton,
            )
        }
    }
}

@Composable
private fun HomePageBody(
    state: HomeUiState,
    onClickSetting: (City) -> Unit,
    onClickCurrentLocation: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        state.weatherColor.copy(alpha = 0.1f),
                        state.weatherColor.copy(alpha = 0.4f),
                    ),
                    tileMode = TileMode.Clamp,
                )
            )
            .safeDrawingPadding()
            .padding(20.dp),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // TODO : to AppBar
            Title(
                title = state.title,
                onClickSetting = onClickSetting,
                onClickCurrentLocation = onClickCurrentLocation,
            )
            Spacer(
                modifier = Modifier.height(16.dp),
            )
            if (state.temperature != null && state.description != null && state.weatherType != null) {
                MainInfo(
                    baseColor = state.weatherColor,
                    weatherType = state.weatherType,
                    temperature = state.temperature,
                    description = state.description,
                )
                Spacer(
                    modifier = Modifier.height(16.dp),
                )
            }
            if (state.humidity != null || state.rainfall != null) {
                AdditionalInfoCard(
                    humidity = state.humidity,
                    rainfall = state.rainfall,
                )
            }
        }
        if (state.isLoading) {
            CircularProgressIndicator(
                color = Color.White,
            )
        }
    }
}

@Preview
@Composable
@Suppress("unused")
private fun HomePageBodyPreview() {
    HomePageBody(
        state = HomeUiState(),
        onClickSetting = {},
        onClickCurrentLocation = {},
    )
}
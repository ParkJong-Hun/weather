package co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui.pages.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
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
import co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui.di.koinViewModel
import co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui.navigation.AppPages
import co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui.navigation.NavigateEvent
import co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui.navigation.currentNavigator
import co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui.pages.home.components.organism.AdditionalInfoCard
import co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui.pages.home.components.organism.Footer
import co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui.pages.home.components.organism.MainInfo
import co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui.pages.home.components.organism.Title
import co.kr.parkjonghun.composemultiplatformtestairfield.uicomponent.template.CommonOkDialog
import org.jetbrains.compose.ui.tooling.preview.Preview

// TODO use SharedTransitionScope
@Composable
fun NavGraphBuilder.HomePage(
    homeViewModel: HomeViewModel = koinViewModel(),
) {
    val state by homeViewModel.uiState.collectAsState()
    val appNavigator = currentNavigator

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        HomePageBody(
            state = state,
            onClickSetting = { appNavigator.emitEvent(NavigateEvent.NavigateTo(AppPages.Search)) },
            onClickCurrentLocation = homeViewModel::onClickCurrentLocation,
            onClickLicense = { appNavigator.emitEvent(NavigateEvent.NavigateTo(AppPages.License)) }
        )
        if (state.isLoading) {
            CircularProgressIndicator(
                color = Color.White,
            )
        }
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
    onClickSetting: () -> Unit,
    onClickCurrentLocation: () -> Unit,
    onClickLicense: () -> Unit,
) {
    Column(
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
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // TODO : to AppBar
        Title(
            title = state.title,
            onClickSetting = onClickSetting,
            onClickCurrentLocation = onClickCurrentLocation,
            modifier = Modifier.fillMaxWidth().heightIn(70.dp),
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
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(
                modifier = Modifier.height(16.dp),
            )
        }
        if (state.humidity != null || state.rainfall != null) {
            AdditionalInfoCard(
                humidity = state.humidity,
                rainfall = state.rainfall,
                modifier = Modifier.fillMaxWidth(),
            )
        }
        Footer(
            onClickLicense = onClickLicense,
            modifier = Modifier.fillMaxWidth()
        )
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
        onClickLicense = {},
    )
}
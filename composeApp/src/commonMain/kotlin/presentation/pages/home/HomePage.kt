package presentation.pages.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import domain.entity.City
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.WeatherColor
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
    HomePageBody(
        state = state,
        onClickSetting = homeViewModel::onClickCity,
        onClickCurrentLocation = homeViewModel::onClickCurrentLocation,
    )
}

@Composable
private fun HomePageBody(
    state: HomeUiState,
    onClickSetting: (City) -> Unit,
    onClickCurrentLocation: () -> Unit,
) {
    val rainfall = state.rainfall?.filter { it.isDigit() }?.toInt() ?: 0
    val baseColor = when {
        rainfall != 0 -> {
            when {
                rainfall < 10 -> WeatherColor.Cloudy
                else -> WeatherColor.Rainy
            }
        }

        state.temperature != null -> {
            val temperature = state.temperature.filter { it.isDigit() }.toInt()
            when {
                temperature < 12 -> WeatherColor.Cold
                temperature < 18 -> WeatherColor.Cool
                temperature < 26 -> WeatherColor.Pleasant
                temperature < 31 -> WeatherColor.Warm
                else -> WeatherColor.Hot
            }
        }

        else -> WeatherColor.Pleasant
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = baseColor.copy(alpha = 0.1f))
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
            if (state.temperature != null || state.description != null) {
                MainInfo(
                    baseColor = baseColor,
                    temperature = state.temperature,
                    description = state.description,
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
            CircularProgressIndicator()
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
package presentation.pages.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraphBuilder
import compose_multiplatform_test_airfield.composeapp.generated.resources.Res
import compose_multiplatform_test_airfield.composeapp.generated.resources.ic_map_24
import domain.entity.City
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.di.koinViewModel
import presentation.pages.home.components.AdditionalInfoText

// TODO use SharedTransitionScope
@Composable
fun NavGraphBuilder.HomePage(
    homeViewModel: HomeViewModel = koinViewModel(),
) {
    val state by homeViewModel.uiState.collectAsState()
    HomePageBody(
        state = state,
        onClickSetting = (homeViewModel::onClickCity)
    )
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun HomePageBody(
    state: HomeUiState,
    onClickSetting: (City) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row {
            Text(
                text = state.title,
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 24.sp,
                    textMotion = TextMotion.Animated,
                ),
                maxLines = 1,
            )
            Icon(
                painter = painterResource(Res.drawable.ic_map_24),
                contentDescription = "Location",
                tint = MaterialTheme.colors.primary,
                // FIXME : Navigate to the search page
                modifier = Modifier.clickable {
                    onClickSetting(City.Osaka)
                }
            )
        }
        Spacer(
            modifier = Modifier.height(16.dp),
        )
        Text(
            text = state.temperature ?: "",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp,
            ),
            maxLines = 1,
        )
        Spacer(
            modifier = Modifier.height(16.dp),
        )
        AdditionalInfoText(
            title = "Humidity:",
            description = state.humidity ?: "",
        )
        AdditionalInfoText(
            title = "Rainfall:",
            description = state.rainfall ?: "",
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
    )
}
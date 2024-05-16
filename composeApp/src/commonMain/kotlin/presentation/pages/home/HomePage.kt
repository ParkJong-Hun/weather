package presentation.pages.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraphBuilder
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.di.koinViewModel

// TODO use SharedTransitionScope
@Composable
fun NavGraphBuilder.HomePage(
    homeViewModel: HomeViewModel = koinViewModel(),
) {
    val state by homeViewModel.uiState.collectAsState()
    HomePageBody(
        state = state,
        onClickButton = (homeViewModel::onClickExampleButton)
    )
}

@Composable
private fun HomePageBody(
    state: HomeUiState,
    onClickButton: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            fontSize = 36.sp,
            text = state.person,
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Button(
            onClick = onClickButton,
        ) {
            Text("Get Person")
        }
    }
}

@Preview
@Composable
private fun HomePageBodyPreview() {
    HomePageBody(
        state = HomeUiState(),
        onClickButton = {},
    )
}
package presentation.pages.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.di.koinViewModel

// TODO use SharedTransitionScope
@Composable
fun NavGraphBuilder.HomePage(
    homeViewModel: HomeViewModel = koinViewModel(),
) {

}

@Composable
private fun HomePageBody() {

}

@Preview
@Composable
private fun HomePageBodyPreview() {
    HomePageBody()
}
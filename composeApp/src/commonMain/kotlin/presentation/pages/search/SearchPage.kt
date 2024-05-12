package presentation.pages.search

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.di.koinViewModel

// TODO use SharedTransitionScope
@Composable
fun NavGraphBuilder.SearchPage(
    searchViewModel: SearchViewModel = koinViewModel(),
) {

}

@Composable
private fun SearchPageBody() {

}

@Preview
@Composable
private fun SearchPageBodyPreview() {
    SearchPageBody()
}
package presentation.pages.search

import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.di.koinViewModel

// TODO NavGraphBuilder.() -> Unit
@Composable
fun SearchPage(
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
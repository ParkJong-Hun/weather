package infrastructure.ui.pages.search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import domain.entity.City
import infrastructure.ui.di.koinViewModel
import infrastructure.ui.pages.search.components.organism.CityList
import org.jetbrains.compose.ui.tooling.preview.Preview

// TODO use SharedTransitionScope
@Composable
fun NavGraphBuilder.SearchPage(
    searchViewModel: SearchViewModel = koinViewModel(),
) {
    val state by searchViewModel.uiState.collectAsState()
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        SearchPageBody(
            state = state,
            onClickCity = {
                // TODO
            },
        )
//        if (false) {
//            CommonOkDialog(
//                title = state.dialogTitle!!,
//                message = state.dialogMessage!!,
//                onDismiss = searchViewModel::onClickDialogOkButton,
//            )
//        }
    }
}

@Composable
private fun SearchPageBody(
    state: SearchUiState,
    onClickCity: (City) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CityList(
            cities = City.entries,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Preview
@Composable
private fun SearchPageBodyPreview() {
    SearchPageBody(
        state = SearchUiState(
            isLoading = false,
        ),
        onClickCity = {},
    )
}
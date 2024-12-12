package ui.pages.search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.City
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.components.template.CommonOkDialog
import ui.di.koinViewModel
import ui.navigation.NavigateEvent
import ui.navigation.currentNavigator
import ui.pages.search.components.organism.CityList
import ui.pages.search.components.organism.SearchTitle

// TODO use SharedTransitionScope
@Composable
fun NavGraphBuilder.SearchPage(
    searchViewModel: SearchViewModel = koinViewModel(),
) {
    val state by searchViewModel.uiState.collectAsState()
    val appNavigator = currentNavigator

    LaunchedEffect(state.isComplete) {
        if (state.isComplete) {
            appNavigator.emitEvent(
                NavigateEvent.PopBackStack,
            )
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        SearchPageBody(
            onClickBack = { appNavigator.emitEvent(NavigateEvent.PopBackStack) },
            onClickCity = searchViewModel::onClickCity,
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
                onDismiss = searchViewModel::onClickDialogOkButton,
            )
        }
    }
}

@Composable
private fun SearchPageBody(
    onClickBack: () -> Unit,
    onClickCity: (City) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SearchTitle(
            onClickBack = onClickBack,
            modifier = Modifier.heightIn(70.dp).fillMaxWidth(),
        )
        CityList(
            cities = City.entries,
            onClickCity = onClickCity,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Preview
@Composable
@Suppress("unused")
private fun SearchPageBodyPreview() {
    SearchPageBody(
        onClickBack = {},
        onClickCity = {},
    )
}
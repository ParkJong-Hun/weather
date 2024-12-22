package co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui.pages.license

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.GetLibraryLicensesUseCase
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.LibraryLicense
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.LicenseInfo
import co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui.navigation.NavigateEvent
import co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui.navigation.currentNavigator
import co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui.pages.license.components.organism.LibraryLicenseCard
import co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui.pages.license.components.organism.LicenseTitle
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject

// TODO use SharedTransitionScope
@Composable
fun NavGraphBuilder.LicensePage() {
    val getLibraryLicensesUseCase: GetLibraryLicensesUseCase = koinInject()
    var libraryLicenses by remember { mutableStateOf<List<LibraryLicense>>(emptyList()) }
    val appNavigator = currentNavigator

    LaunchedEffect(getLibraryLicensesUseCase) {
        libraryLicenses = getLibraryLicensesUseCase().toList()
    }

    LicensePageBody(
        libraryLicenses,
        onClickBack = { appNavigator.emitEvent(NavigateEvent.PopBackStack) },
    )
}

@Composable
fun LicensePageBody(
    libraryLicenses: List<LibraryLicense>,
    onClickBack: () -> Unit,
) {
    Column {
        LicenseTitle(
            onClickBack = onClickBack,
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            items(libraryLicenses) { libraryLicense ->
                LibraryLicenseCard(libraryLicense)
            }
        }
    }
}


@Preview
@Composable
@Suppress("unused")
private fun LicensePagePreview() {
    LicensePageBody(
        libraryLicenses = listOf(
            LibraryLicense(
                groupId = "org.jetbrains.compose.ui",
                artifactId = "ui",
                name = "Compose UI primitives",
                version = "1.6.2",
                url = "https://github.com/JetBrains/compose-jb",
                licenses = listOf(
                    LicenseInfo(
                        identifier = "Apache-2.0",
                        name = "Apache License 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0",
                    )
                ),
            )
        ),
        onClickBack = {},
    )
}
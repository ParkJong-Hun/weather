package co.kr.parkjonghun.composemultiplatformtestairfield.feature.license.license

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import co.kr.parkjonghun.composemultiplatformtestairfield.application.usecase.GetLibraryLicensesUseCase
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.LibraryLicense
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.LicenseInfo
import co.kr.parkjonghun.composemultiplatformtestairfield.feature.license.license.components.organism.LibraryLicenseCard
import co.kr.parkjonghun.composemultiplatformtestairfield.feature.license.license.components.organism.LicenseTitle
import co.kr.parkjonghun.composemultiplatformtestairfield.uicore.navigation.NavigateEvent
import co.kr.parkjonghun.composemultiplatformtestairfield.uicore.navigation.currentNavigator
import org.koin.compose.koinInject

// TODO use SharedTransitionScope
@androidx.compose.runtime.Composable
fun NavGraphBuilder.LicensePage() {
    val getLibraryLicensesUseCase: GetLibraryLicensesUseCase = koinInject()
    var libraryLicenses by remember { mutableStateOf<List<LibraryLicense>>(emptyList()) }
    val appNavigator = currentNavigator

    androidx.compose.runtime.LaunchedEffect(getLibraryLicensesUseCase) {
        libraryLicenses = getLibraryLicensesUseCase().toList()
    }

    LicensePageBody(
        libraryLicenses,
        onClickBack = { appNavigator.emitEvent(NavigateEvent.PopBackStack) },
    )
}

@androidx.compose.runtime.Composable
fun LicensePageBody(
    libraryLicenses: List<LibraryLicense>,
    onClickBack: () -> Unit,
) {
    Column(
        modifier = Modifier.Companion
            .fillMaxSize()
            .safeDrawingPadding()
            .padding(20.dp),
    ) {
        LicenseTitle(
            onClickBack = onClickBack,
            modifier = Modifier.Companion.heightIn(70.dp).fillMaxWidth(),
        )
        LazyColumn(
            modifier = Modifier.Companion.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Companion.CenterHorizontally,
        ) {
            items(libraryLicenses) { libraryLicense ->
                LibraryLicenseCard(
                    libraryLicense = libraryLicense,
                    modifier = Modifier.Companion
                        .fillMaxWidth()
                        .padding(8.dp),
                )
            }
        }
    }
}


@org.jetbrains.compose.ui.tooling.preview.Preview
@androidx.compose.runtime.Composable
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
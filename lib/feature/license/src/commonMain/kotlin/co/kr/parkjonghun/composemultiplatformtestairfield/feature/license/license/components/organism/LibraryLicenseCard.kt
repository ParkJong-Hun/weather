package co.kr.parkjonghun.composemultiplatformtestairfield.feature.license.license.components.organism

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.LibraryLicense
import co.kr.parkjonghun.composemultiplatformtestairfield.uicomponent.atom.Link

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun LibraryLicenseCard(
    libraryLicense: LibraryLicense,
    modifier: Modifier = Modifier,
) {
    val libraryName = remember { libraryLicense.name }
    val libraryModule =
        remember { "${libraryLicense.groupId}:${libraryLicense.artifactId}:${libraryLicense.version}" }

    Card(
        modifier = modifier.defaultMinSize(48.dp),
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
        ) {
            Text(
                text = libraryName,
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 24.sp,
                    textMotion = TextMotion.Animated,
                ),
            )
            Text(
                text = libraryModule,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp,
                    textMotion = TextMotion.Animated,
                ),
            )
            FlowRow {
                libraryLicense.licenses.forEach { licenseInfo ->
                    Link(
                        text = licenseInfo.name,
                        url = licenseInfo.url
                    )
                }
            }
        }
    }
}

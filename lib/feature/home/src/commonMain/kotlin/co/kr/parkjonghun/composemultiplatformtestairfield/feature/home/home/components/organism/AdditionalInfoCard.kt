package co.kr.parkjonghun.composemultiplatformtestairfield.feature.home.home.components.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.kr.parkjonghun.composemultiplatformtestairfield.feature.home.extension.toDoubleSafety
import co.kr.parkjonghun.composemultiplatformtestairfield.feature.home.home.components.molecule.AdditionalInfoText
import compose_multiplatform_test_airfield.lib.feature.home.generated.resources.Res
import compose_multiplatform_test_airfield.lib.feature.home.generated.resources.humidity
import compose_multiplatform_test_airfield.lib.feature.home.generated.resources.rainfall
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun AdditionalInfoCard(
    humidity: String?,
    rainfall: String?,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .background(
                color = Color.White.copy(alpha = 0.4f),
                shape = RoundedCornerShape(8.dp),
            )
            .padding(16.dp),
    ) {
        if (humidity != null) {
            AdditionalInfoText(
                title = stringResource(Res.string.humidity),
                description = humidity,
                color = Color.DarkGray,
            )
        }
        if (rainfall != null) {
            AdditionalInfoText(
                title = stringResource(Res.string.rainfall),
                description = rainfall,
                color = Color.DarkGray,
                valueColor = if (rainfall.toDoubleSafety() > 0.0) {
                    Color.Blue
                } else {
                    Color.Gray
                },
            )
        }
    }
}

@Preview
@Composable
@Suppress("unused")
private fun AdditionalInfoCardPreview() {
    AdditionalInfoCard(
        humidity = "50%",
        rainfall = "15.4mm",
    )
}
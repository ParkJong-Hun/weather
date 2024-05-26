package presentation.pages.home.components.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.pages.home.components.molecule.AdditionalInfoText

@Composable
internal fun AdditionalInfoCard(
    humidity: String?,
    rainfall: String?,
) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .background(
                color = MaterialTheme.colors.secondary,
                shape = RoundedCornerShape(8.dp),
            )
            .padding(16.dp),
    ) {
        if (humidity != null) {
            AdditionalInfoText(
                // FIXME : use Resource
                title = "湿度:",
                description = humidity,
                color = MaterialTheme.colors.onSecondary,
            )
        }
        if (rainfall != null) {
            AdditionalInfoText(
                // FIXME : use Resource
                title = "降雨量:",
                description = rainfall,
                color = MaterialTheme.colors.onSecondary,
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
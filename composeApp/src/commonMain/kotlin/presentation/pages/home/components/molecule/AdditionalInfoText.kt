package presentation.pages.home.components.molecule

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
internal fun AdditionalInfoText(
    title: String,
    description: String,
    color: Color = Color.Unspecified,
    valueColor: Color = Color.Unspecified,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            color = color.copy(alpha = 0.8f),
            text = title,
            fontSize = 14.sp,
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            color = if (valueColor != Color.Unspecified) color else valueColor,
            text = description,
            fontSize = 14.sp,
        )
    }
}

@Preview
@Composable
@Suppress("unused")
private fun AdditionalInfoTextPreview() {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        AdditionalInfoText(
            title = "Title",
            description = "Description",
        )
    }
}
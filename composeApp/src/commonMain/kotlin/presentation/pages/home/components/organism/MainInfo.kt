package presentation.pages.home.components.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
internal fun MainInfo(
    temperature: String?,
    description: String?,
    baseColor: Color,
) {
    Column(
        modifier = Modifier
            .background(
                color = baseColor.copy(alpha = 0.8f),
                shape = RoundedCornerShape(16.dp),
            )
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (temperature != null) {
            Text(
                text = temperature,
                style = TextStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 36.sp,
                ),
                maxLines = 1,
            )
            if (description != null) {
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
        if (description != null) {
            Text(
                text = description,
                style = TextStyle(
                    color = Color.White.copy(alpha = 0.8f),
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                ),
                maxLines = 1,
            )
        }
    }
    Spacer(
        modifier = Modifier.height(16.dp),
    )
}

@Preview
@Composable
@Suppress("unused")
private fun MainInfoPreview() {
    MainInfo(
        temperature = "25°C",
        description = "晴れ",
        baseColor = Color.Green,
    )
}
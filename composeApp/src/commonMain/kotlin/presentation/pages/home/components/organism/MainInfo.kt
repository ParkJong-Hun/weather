package presentation.pages.home.components.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
internal fun MainInfo(
    temperature: String?,
    description: String?,
) {
    Column(
        modifier = Modifier
            .background(
                color = MaterialTheme.colors.primary,
                shape = CircleShape,
            )
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (temperature != null) {
            Text(
                text = temperature,
                style = TextStyle(
                    color = MaterialTheme.colors.onPrimary,
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
                    color = MaterialTheme.colors.onPrimary.copy(alpha = 0.8f),
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
    )
}
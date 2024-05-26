package presentation.pages.home.components.organism

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose_multiplatform_test_airfield.composeapp.generated.resources.Res
import compose_multiplatform_test_airfield.composeapp.generated.resources.ic_map_24
import compose_multiplatform_test_airfield.composeapp.generated.resources.ic_nearby_24
import domain.entity.City
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun Title(
    title: String,
    onClickSetting: (City) -> Unit,
    onClickCurrentLocation: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                textMotion = TextMotion.Animated,
            ),
            maxLines = 1,
        )
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            painter = painterResource(Res.drawable.ic_map_24),
            contentDescription = "特定都市を調べる",
            tint = Color.Blue,
            // FIXME : Navigate to the search page
            modifier = Modifier.clickable {
                onClickSetting(City.Osaka)
            }
        )
        Spacer(modifier = Modifier.width(4.dp))
        Icon(
            painter = painterResource(Res.drawable.ic_nearby_24),
            contentDescription = "現在位置を調べる",
            tint = Color.Blue,
            modifier = Modifier.clickable(onClick = onClickCurrentLocation),
        )
    }
    Spacer(
        modifier = Modifier.height(16.dp),
    )
}

@Preview
@Composable
@Suppress("unused")
private fun TitlePreview() {
    Title(
        title = "Title",
        onClickSetting = {},
        onClickCurrentLocation = {},
    )
}
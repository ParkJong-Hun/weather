package presentation.pages.home.components.organism

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import presentation.Color

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun Title(
    title: String,
    onClickSetting: (City) -> Unit,
    onClickCurrentLocation: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painter = painterResource(Res.drawable.ic_map_24),
            contentDescription = "特定都市を調べる",
            tint = Color.Link,
            // FIXME : Navigate to the search page
            modifier = Modifier.clickable {
                onClickSetting(City.Osaka)
            }
        )
        Text(
            text = title,
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                textMotion = TextMotion.Animated,
            ),
            maxLines = 1,
        )
        Icon(
            painter = painterResource(Res.drawable.ic_nearby_24),
            contentDescription = "現在位置を調べる",
            tint = Color.Link,
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
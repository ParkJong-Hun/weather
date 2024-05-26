package presentation.pages.home.components.organism

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose_multiplatform_test_airfield.composeapp.generated.resources.Res
import compose_multiplatform_test_airfield.composeapp.generated.resources.ic_cloudy_96
import compose_multiplatform_test_airfield.composeapp.generated.resources.ic_little_cloudy_96
import compose_multiplatform_test_airfield.composeapp.generated.resources.ic_little_rainy_96
import compose_multiplatform_test_airfield.composeapp.generated.resources.ic_mist_96
import compose_multiplatform_test_airfield.composeapp.generated.resources.ic_rainy_96
import compose_multiplatform_test_airfield.composeapp.generated.resources.ic_snowy_96
import compose_multiplatform_test_airfield.composeapp.generated.resources.ic_storm_96
import compose_multiplatform_test_airfield.composeapp.generated.resources.ic_sunny_96
import compose_multiplatform_test_airfield.composeapp.generated.resources.ic_umbrella_96
import domain.entity.WeatherType
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.WeatherColor

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun MainInfo(
    weatherType: WeatherType,
    baseColor: Color,
    temperature: String,
    description: String,
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
        Image(
            modifier = Modifier.size(96.dp),
            painter = when (weatherType) {
                WeatherType.SUNNY -> painterResource(Res.drawable.ic_sunny_96)
                WeatherType.FEW_CLOUDS -> painterResource(Res.drawable.ic_little_cloudy_96)
                WeatherType.SCATTERED_CLOUDS -> painterResource(Res.drawable.ic_cloudy_96)
                WeatherType.BROKEN_CLOUDS -> painterResource(Res.drawable.ic_umbrella_96)
                WeatherType.SHOWER_RAIN -> painterResource(Res.drawable.ic_little_rainy_96)
                WeatherType.RAIN -> painterResource(Res.drawable.ic_rainy_96)
                WeatherType.SNOW -> painterResource(Res.drawable.ic_snowy_96)
                WeatherType.THUNDERSTORM -> painterResource(Res.drawable.ic_storm_96)
                WeatherType.MIST -> painterResource(Res.drawable.ic_mist_96)
            },
            contentDescription = "Weather Type",
            contentScale = ContentScale.Fit,
            colorFilter = ColorFilter.tint(
                when (weatherType) {
                    WeatherType.SUNNY -> WeatherColor.Sun
                    WeatherType.FEW_CLOUDS -> WeatherColor.Sun
                    WeatherType.SCATTERED_CLOUDS -> WeatherColor.Cloud
                    WeatherType.BROKEN_CLOUDS -> WeatherColor.Cloud
                    WeatherType.SHOWER_RAIN -> WeatherColor.Rainy
                    WeatherType.RAIN -> WeatherColor.Rainy
                    WeatherType.SNOW -> WeatherColor.Snow
                    WeatherType.THUNDERSTORM -> WeatherColor.Cloud
                    WeatherType.MIST -> WeatherColor.Cloud
                }
            ),
        )
        Text(
            text = temperature,
            style = TextStyle(
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp,
            ),
            maxLines = 1,
        )
        Spacer(modifier = Modifier.height(8.dp))
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
        weatherType = WeatherType.SUNNY,
    )
}
package infrastructure.ui.pages.search.components.molecule

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import domain.entity.City
import domain.entity.WeatherType
import domain.usecase.GetWeatherByCityUseCase
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun CityCell(
    city: City,
    onClickCity: (City) -> Unit,
    modifier: Modifier = Modifier,
) {
    // remembered
    val useCase: GetWeatherByCityUseCase = koinInject()
    val state by useCase(city).collectAsState(null)

    Row(
        modifier = modifier.heightIn(64.dp).clickable { onClickCity(city) },
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = state?.location ?: "...",
            fontSize = 18.sp,
        )
        Spacer(modifier = Modifier.weight(1f))
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = if (state != null) "${state?.weatherInfo?.temperature}${state?.weatherInfo?.temperatureSymbolType?.symbol}" else "...",
                fontSize = 16.sp,
            )
            Spacer(modifier = Modifier.width(8.dp))
            if (state != null) {
                Icon(
                    painter = painterResource(
                        when (state?.weatherInfo?.weatherType) {
                            WeatherType.SUNNY -> Res.drawable.ic_sunny_96
                            WeatherType.FEW_CLOUDS -> Res.drawable.ic_little_cloudy_96
                            WeatherType.SCATTERED_CLOUDS -> Res.drawable.ic_cloudy_96
                            WeatherType.BROKEN_CLOUDS -> Res.drawable.ic_umbrella_96
                            WeatherType.SHOWER_RAIN -> Res.drawable.ic_little_rainy_96
                            WeatherType.RAIN -> Res.drawable.ic_rainy_96
                            WeatherType.SNOW -> Res.drawable.ic_snowy_96
                            WeatherType.THUNDERSTORM -> Res.drawable.ic_storm_96
                            WeatherType.MIST -> Res.drawable.ic_mist_96
                            null -> error("do not reach here")
                        }
                    ),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Preview
@Composable
@Suppress("unused")
private fun CityCellPreview() {
    CityCell(
        city = City.Tokyo,
        onClickCity = {},
    )
}
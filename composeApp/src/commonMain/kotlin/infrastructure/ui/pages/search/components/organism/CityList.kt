package infrastructure.ui.pages.search.components.organism

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import domain.entity.City
import infrastructure.ui.pages.search.components.molecule.CityCell
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
internal fun CityList(
    cities: List<City>,
    onClickCity: (City) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
    ) {
        items(cities) { city ->
            CityCell(
                city = city,
                onClickCity = onClickCity,
            )
        }
    }
}

@Preview
@Composable
@Suppress("unused")
private fun CityListPreview() {
    CityList(
        cities = listOf(
            City.Sapporo,
            City.Sendai,
            City.Tokyo,
            City.Yokohama,
            City.Nagoya,
            City.Kyoto,
            City.Osaka,
            City.Hiroshima,
            City.Fukuoka,
            City.Okinawa,
        ),
        onClickCity = {},
    )
}

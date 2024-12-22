package co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui.pages.license.components.organism

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import co.kr.parkjonghun.composemultiplatformtestairfield.uicomponent.Color

@Composable
internal fun LicenseTitle(
    onClickBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
            // FIXME
            contentDescription = "back",
            tint = Color.Link,
            modifier = Modifier.clickable(onClick = onClickBack),
        )
    }
}
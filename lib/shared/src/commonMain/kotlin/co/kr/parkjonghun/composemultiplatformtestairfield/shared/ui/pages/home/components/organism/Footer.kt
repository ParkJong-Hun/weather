package co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui.pages.home.components.organism

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.unit.sp

@Composable
internal fun Footer(
    onClickLicense: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            // TODO: i18n
            text = "License",
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                textMotion = TextMotion.Animated,
            ),
            maxLines = 1,
            modifier = Modifier.clickable {
                onClickLicense()
            }
        )
    }
}
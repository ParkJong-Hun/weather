package co.kr.parkjonghun.composemultiplatformtestairfield.uicomponent.atom

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import co.kr.parkjonghun.composemultiplatformtestairfield.uicomponent.Color
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun Link(
    text: String,
    url: String,
    annotation: String = url,
) {
    val uriHandler = LocalUriHandler.current

    ClickableText(
        text = buildAnnotatedString {
            append(text)
            addStyle(
                style = SpanStyle(
                    color = Color.Link,
                    textDecoration = TextDecoration.Underline,
                ),
                start = 0,
                end = text.length,
            )
            addStringAnnotation(
                tag = text,
                annotation = annotation,
                start = 0,
                end = text.length,
            )
        },
        onClick = {
            uriHandler.openUri(url)
        },
    )
}

@Preview
@Composable
@Suppress("unused")
private fun LinkPreview() {
    Link(
        text = "Weather",
        url = "https://github.com/ParkJong-Hun/weather",
        annotation = "https://github.com/ParkJong-Hun",
    )
}

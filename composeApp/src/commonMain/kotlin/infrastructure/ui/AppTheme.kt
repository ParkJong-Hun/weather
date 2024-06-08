package infrastructure.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import infrastructure.ui.navigation.AppNavigator
import infrastructure.ui.navigation.LocalNavigator

@Composable
fun AppTheme(
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalNavigator provides AppNavigator(),
    ) {
        MaterialTheme {
            content()
        }
    }
}
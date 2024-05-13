package presentation

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import presentation.navigation.AppNavigator
import presentation.navigation.LocalNavigator

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
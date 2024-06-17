package ui

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import ui.navigation.AppNavigator
import ui.navigation.LocalNavigator
import org.koin.compose.KoinContext
import org.koin.compose.koinInject

@Composable
fun AppTheme(
    content: @Composable () -> Unit,
) {
    KoinContext {
        val appNavigatorInstance: AppNavigator = koinInject()
        CompositionLocalProvider(
            LocalNavigator provides appNavigatorInstance,
        ) {
            MaterialTheme {
                content()
            }
        }
    }
}
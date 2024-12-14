package co.kr.parkjonghun.composemultiplatformairfield.shared.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import co.kr.parkjonghun.composemultiplatformairfield.shared.ui.navigation.AppNavigator
import co.kr.parkjonghun.composemultiplatformairfield.shared.ui.navigation.LocalNavigator
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
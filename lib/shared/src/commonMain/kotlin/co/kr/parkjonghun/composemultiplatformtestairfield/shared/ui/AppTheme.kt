package co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import co.kr.parkjonghun.composemultiplatformtestairfield.uicore.navigation.AppNavigator
import co.kr.parkjonghun.composemultiplatformtestairfield.uicore.navigation.LocalNavigator
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
package co.kr.parkjonghun.composemultiplatformtestairfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import presentation.App
import presentation.navigation.AppNavigator
import presentation.navigation.LocalNavigator

class MainActivity : ComponentActivity() {
    private val appNavigator = AppNavigator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CompositionLocalProvider(
                LocalNavigator provides appNavigator,
            ) {
                App(appNavigator = appNavigator)
            }
        }
    }
}

package co.kr.parkjonghun.composemultiplatformtestairfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import dev.icerock.moko.permissions.PermissionsController
import org.koin.android.ext.android.inject
import infrastructure.ui.App
import infrastructure.ui.navigation.AppNavigator
import infrastructure.ui.navigation.LocalNavigator

class MainActivity : ComponentActivity() {
    private val appNavigator = AppNavigator()
    private val permissionsController: PermissionsController by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        permissionsController.bind(this)
        setContent {
            CompositionLocalProvider(
                LocalNavigator provides appNavigator,
            ) {
                App(appNavigator = appNavigator)
            }
        }
    }
}

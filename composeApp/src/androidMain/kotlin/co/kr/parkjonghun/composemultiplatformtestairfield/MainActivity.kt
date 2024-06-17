package co.kr.parkjonghun.composemultiplatformtestairfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dev.icerock.moko.permissions.PermissionsController
import infrastructure.ui.App
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    private val permissionsController: PermissionsController by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        permissionsController.bind(this)
        setContent {
            App()
        }
    }
}

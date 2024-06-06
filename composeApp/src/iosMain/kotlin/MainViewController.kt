import androidx.compose.ui.window.ComposeUIViewController
import presentation.App
import presentation.navigation.AppNavigator

@Suppress("unused", "FunctionName")
fun MainViewController() = ComposeUIViewController(
    configure = {
        KoinInitializer().start()
    }
) {
    App(appNavigator = AppNavigator())
}

// Add more view controller when needed
// TODO: Try using SwiftUI and This together
import androidx.compose.ui.window.ComposeUIViewController
import infrastructure.ui.App
import infrastructure.ui.navigation.AppNavigator

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
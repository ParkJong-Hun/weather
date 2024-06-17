import androidx.compose.ui.window.ComposeUIViewController
import infrastructure.ui.App

@Suppress("unused", "FunctionName")
fun MainViewController() = ComposeUIViewController(
    configure = {
        KoinInitializer().start()
    }
) {
    App()
}

// Add more view controller when needed
// TODO: Try using SwiftUI and This together
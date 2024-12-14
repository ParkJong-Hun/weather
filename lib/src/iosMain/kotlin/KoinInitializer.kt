import org.koin.core.context.startKoin

actual class KoinInitializer {
    actual fun start() {
        startKoin {
            modules(
                sharedAppDIContainer,
                iosNativeDIContainer,
            )
        }
    }
}
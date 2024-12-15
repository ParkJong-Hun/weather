package co.kr.parkjonghun.composemultiplatformtestairfield.shared

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

actual class KoinInitializer(
    private val context: Context,
) {
    actual fun start() {
        startKoin {
            androidContext(context)
            androidLogger()
            modules(
                sharedAppDIContainer,
                androidNativeDIContainer,
            )
        }
    }
}
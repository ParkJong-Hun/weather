package co.kr.parkjonghun.composemultiplatformtestairfield

import co.kr.parkjonghun.composemultiplatformairfield.shared.KoinInitializer
import android.app.Application

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KoinInitializer(applicationContext).start()
    }
}
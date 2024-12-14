package co.kr.parkjonghun.composemultiplatformtestairfield

import KoinInitializer
import android.app.Application

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KoinInitializer(applicationContext).start()
    }
}
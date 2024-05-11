package co.kr.parkjonghun.composemultiplatformtestairfield

import android.app.Application
import KoinInitializer

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KoinInitializer(applicationContext).init()
    }
}
package infrastructure.adapter.controller.device

import AndroidPlatform
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.Platform

actual fun getPlatform(): Platform = AndroidPlatform()
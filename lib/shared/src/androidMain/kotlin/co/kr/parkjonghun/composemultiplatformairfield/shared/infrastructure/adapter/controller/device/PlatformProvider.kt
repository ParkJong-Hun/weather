package co.kr.parkjonghun.composemultiplatformairfield.shared.infrastructure.adapter.controller.device

import AndroidPlatform
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.Platform

actual fun getPlatform(): Platform = AndroidPlatform()
package co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.adapter.controller.device

import IOSPlatform
import co.kr.parkjonghun.composemultiplatformtestairfield.domain.Platform

actual fun getPlatform(): Platform = IOSPlatform()
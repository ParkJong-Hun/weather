package infrastructure.adapter.device

import AndroidPlatform
import domain.entity.Platform

actual fun getPlatform(): Platform = AndroidPlatform()
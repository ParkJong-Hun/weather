package domain.gateway.platform

import AndroidPlatform
import domain.entity.Platform

actual fun getPlatform(): Platform = AndroidPlatform()
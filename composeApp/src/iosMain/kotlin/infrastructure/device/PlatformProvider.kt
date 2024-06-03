package infrastructure.device

import IOSPlatform
import domain.entity.Platform

actual fun getPlatform(): Platform = IOSPlatform()
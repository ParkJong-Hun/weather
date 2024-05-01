package domain.gateway.platform

import IOSPlatform
import domain.entity.Platform

actual fun getPlatform(): Platform = IOSPlatform()
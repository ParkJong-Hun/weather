package co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.adapter.controller.device

import compose_multiplatform_test_airfield.lib.infrastructure.generated.resources.Res
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
actual suspend fun getLicenseResource(): ByteArray =
    Res.readBytes("files/licensee/iosSimulatorArm64/artifacts.json")
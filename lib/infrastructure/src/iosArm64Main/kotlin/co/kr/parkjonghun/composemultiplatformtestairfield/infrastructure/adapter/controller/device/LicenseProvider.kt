package co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.adapter.controller.device

import co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.adapter.controller.device.model.License
import compose_multiplatform_test_airfield.lib.infrastructure.generated.resources.Res
import kotlinx.serialization.json.Json
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
actual suspend fun getLicenseResource(): List<License> {
    val resource = Res.readBytes("files/licensee/iosArm64/artifacts.json")
    val decoded = resource.decodeToString()
    return Json.decodeFromString<List<License>>(decoded)
}

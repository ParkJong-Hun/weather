package co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.adapter.controller.device

import co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.adapter.controller.device.model.License
import compose_multiplatform_test_airfield.lib.infrastructure.generated.resources.Res
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
actual suspend fun getLicenseResource(): List<License> {
    return withContext(Dispatchers.IO) {
        val resource = Res.readBytes("files/licensee/android/artifacts.json")
        val decoded = resource.decodeToString()
        Json.decodeFromString<List<License>>(decoded)
    }
}

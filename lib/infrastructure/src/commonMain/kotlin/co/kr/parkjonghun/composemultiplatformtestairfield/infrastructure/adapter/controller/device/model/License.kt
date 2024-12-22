package co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure.adapter.controller.device.model

import kotlinx.serialization.Serializable

@Serializable
data class License(
    val artifactId: String,
    val groupId: String,
    val name: String,
    val scm: Scm? = null,
    val spdxLicenses: List<SpdxLicense> = emptyList(),
    val unknownLicenses: List<UnknownLicense> = emptyList(),
    val version: String,
)

@Serializable
data class Scm(
    val url: String,
)

@Serializable
data class SpdxLicense(
    val identifier: String,
    val name: String,
    val url: String,
)

@Serializable
data class UnknownLicense(
    val name: String,
    val url: String,
)

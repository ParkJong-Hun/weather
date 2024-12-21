package co.kr.parkjonghun.composemultiplatformtestairfield.domain

import kotlinx.serialization.Serializable

@Serializable
data class License(
    val artifactId: String,
    val groupId: String,
    val name: String,
    val scm: Scm,
    val spdxLicenses: List<SpdxLicense>,
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

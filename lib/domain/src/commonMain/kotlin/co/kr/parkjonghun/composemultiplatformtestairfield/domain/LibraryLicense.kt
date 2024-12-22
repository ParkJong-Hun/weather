package co.kr.parkjonghun.composemultiplatformtestairfield.domain

data class LibraryLicense(
    val groupId: String,
    val artifactId: String,
    val name: String,
    val version: String,
    val url: String,
    val licenses: List<LicenseInfo>,
)

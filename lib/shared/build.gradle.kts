import com.android.build.gradle.internal.tasks.factory.dependsOn

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsComposeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.licensee)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }

    val iosTarget = listOf(iosX64(), iosArm64(), iosSimulatorArm64())
    iosTarget.forEach {
        it.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(libs.compose.ui.tooling.preview)
            implementation(libs.androidx.activity.compose)
            implementation(libs.koin.android)
            implementation(libs.koin.androidx.compose)
            implementation(libs.gms.location)
        }
        commonMain.dependencies {
            implementation(project(":lib:domain"))
            implementation(project(":lib:infrastructure"))
            implementation(project(":lib:application"))
            implementation(project(":lib:feature:main"))
            implementation(project(":lib:ui-component"))
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(compose.animation)
            implementation(libs.viewmodel)
            implementation(libs.kotlin.stdlib)
            implementation(libs.kotlin.serialization)
            implementation(libs.kotlin.coroutines)
            implementation(libs.kotlin.datetime)
            implementation(libs.compose.navigation)
            api(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.okio)
            implementation(libs.kermit)
            implementation(libs.stately.common)
            implementation(libs.stately.collections)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "co.kr.parkjonghun.composemultiplatformtestairfield.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

licensee {
    // Google
    allowUrl("https://developer.android.com/studio/terms.html")

    allow("Apache-2.0")
    allow("MIT")

    allowUrl("https://github.com/icerockdev/moko-permissions/blob/master/LICENSE.md") {
        because("Apache-2.0, but self-hosted copy of the license")
    }
}

private class Licensee(
    val from: File,
    val to: File,
)

tasks.register("fetchLicensee") {
    val platformLicenseeMappings = setOf(
        // Android
        Licensee(
            from = File("lib/shared/build/reports/licensee/androidRelease/artifacts.json"),
            to = File("lib/infrastructure/src/commonMain/composeResources/files/licensee/android/artifacts.json")
        ),
        // iOS
        Licensee(
            from = File("lib/shared/build/reports/licensee/iosX64/artifacts.json"),
            to = File("lib/infrastructure/src/commonMain/composeResources/files/licensee/iosX64/artifacts.json"),
        ),
        Licensee(
            from = File("lib/shared/build/reports/licensee/iosArm64/artifacts.json"),
            to = File("lib/infrastructure/src/commonMain/composeResources/files/licensee/iosArm64/artifacts.json"),
        ),
        Licensee(
            from = File("lib/shared/build/reports/licensee/iosSimulatorArm64/artifacts.json"),
            to = File("lib/infrastructure/src/commonMain/composeResources/files/licensee/iosSimulatorArm64/artifacts.json"),
        ),
    )

    doFirst {
        platformLicenseeMappings.forEach { item ->
            item.from.copyTo(item.to, true)
        }
    }
}.dependsOn(tasks.check)

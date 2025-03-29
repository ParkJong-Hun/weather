import org.gradle.kotlin.dsl.compose
import org.gradle.kotlin.dsl.kotlin
import org.jetbrains.kotlin.compose.compiler.gradle.ComposeFeatureFlag
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsComposeMultiplatform)
    alias(libs.plugins.jetbrainsComposeHotReload)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlinSerialization)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain.dependencies {
            implementation(project(":lib:application"))
            implementation(project(":lib:domain"))
            implementation(project(":lib:ui-component"))
            implementation(project(":lib:ui-core"))
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
        }
    }
}

android {
    namespace = "co.kr.parkjonghun.composemultiplatformtestairfield.feature.home"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

composeCompiler {
    featureFlags.add(ComposeFeatureFlag.OptimizeNonSkippingGroups)
}

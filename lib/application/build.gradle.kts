import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.ksp)
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
            implementation(project(":lib:domain"))
            implementation(libs.kotlin.stdlib)
            implementation(libs.kotlin.serialization)
            implementation(libs.kotlin.coroutines)
            implementation(libs.kotlin.datetime)
            api(libs.koin.core)
            implementation(libs.kermit)
        }
    }
}

android {
    namespace = "co.kr.parkjonghun.composemultiplatformtestairfield.application"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
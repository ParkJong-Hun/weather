import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import com.codingfeline.buildkonfig.compiler.FieldSpec

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.ktorfit)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.buildKonfig)
}

kotlin {
    val iosTarget = listOf(iosX64(), iosArm64(), iosSimulatorArm64())
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "11"
            }
        }
    }

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
            implementation(libs.ktorfit.lib)
            implementation(libs.ktor.contentnegotiation)
            implementation(libs.ktor.serialization.json)
            implementation(libs.ktor.logging)
            api(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.okio)
            implementation(libs.kermit)
            implementation(libs.stately.common)
            implementation(libs.stately.collections)
            api(libs.moko.permissions)
            api(libs.moko.permissions.compose)
            implementation(libs.multiplatform.settings)
            implementation(libs.multiplatform.settings.coroutines)
            implementation(libs.multiplatform.settings.no.args)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
            implementation(libs.kotlin.test.junit)
            implementation(libs.moko.permissions.test)
        }
    }

    dependencies {
        listOf("IosArm64", "IosX64", "IosSimulatorArm64", "Android", "CommonMainMetadata").forEach {
            add("ksp$it", libs.ktorfit.ksp)
        }
    }
}

android {
    namespace = "co.kr.parkjonghun.composemultiplatformtestairfield.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

// ./gradlew generateBuildKonfig
buildkonfig {
    packageName = "co.kr.parkjonghun.composemultiplatformtestairfield"

    defaultConfigs {
        buildConfigField(
            type = FieldSpec.Type.STRING,
            name = "WEATHER_APP_ID",
            value = gradleLocalProperties(rootDir).getProperty("api_key")
        )
    }
}


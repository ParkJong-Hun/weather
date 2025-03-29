import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import com.codingfeline.buildkonfig.compiler.FieldSpec
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsComposeMultiplatform)
    alias(libs.plugins.jetbrainsComposeHotReload)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.ktorfit)
    alias(libs.plugins.buildKonfig)
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
        androidMain.dependencies {
            implementation(libs.androidx.activity.compose)
            implementation(libs.gms.location)
        }
        commonMain.dependencies {
            implementation(project(":lib:domain"))
            implementation(project(":lib:application"))
            implementation(compose.components.resources)
            implementation(libs.kotlin.stdlib)
            implementation(libs.kotlin.serialization)
            implementation(libs.kotlin.coroutines)
            implementation(libs.kotlin.datetime)
            implementation(libs.ktorfit.lib)
            implementation(libs.ktor.contentnegotiation)
            implementation(libs.ktor.serialization.json)
            implementation(libs.ktor.logging)
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
    namespace = "co.kr.parkjonghun.composemultiplatformtestairfield.infrastructure"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

// ./gradlew generateBuildKonfig
buildkonfig {
    packageName = "co.kr.parkjonghun.composemultiplatformtestairfield"

    defaultConfigs {
        buildConfigField(
            type = FieldSpec.Type.STRING,
            name = "WEATHER_APP_ID",
            value = gradleLocalProperties(rootDir, providers).getProperty("api_key") ?: ""
        )
    }
}

#!/bin/bash

if [ -z "$1" ]; then
  echo "module name: $0"
  exit 1
fi

MODULE_NAME=$1
ROOT_DIR=$(pwd)
MODULE_DIR="$ROOT_DIR/$MODULE_NAME"

if [ -d "$MODULE_DIR" ]; then
  echo "error: $MODULE_NAME is exist."
  exit 1
fi

mkdir -p "$MODULE_DIR/src/commonMain/kotlin"
mkdir -p "$MODULE_DIR/src/androidMain/kotlin"
mkdir -p "$MODULE_DIR/src/iosMain/kotlin"

cat > "$MODULE_DIR/build.gradle.kts" <<EOL
plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
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
    }
}

android {
    namespace = "co.kr.parkjonghun.composemultiplatformtestairfield.$MODULE_NAME"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

EOL

if grep -q "include(\":$MODULE_NAME\")" "$ROOT_DIR/settings.gradle.kts"; then
  echo "$MODULE_NAME is already exist in settings.gradle.kts."
else
  echo "include(\":$MODULE_NAME\")" >> "$ROOT_DIR/settings.gradle.kts"
  echo "$MODULE_NAME is added in settings.gradle.kts"
fi

echo "script done"
exit 0
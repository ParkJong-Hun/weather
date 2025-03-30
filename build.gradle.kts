plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.jetbrainsComposeMultiplatform) apply false
    alias(libs.plugins.jetbrainsComposeHotReload) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.ktorfit) apply false
    alias(libs.plugins.kotlinSerialization) apply false
    alias(libs.plugins.buildKonfig) apply false
    alias(libs.plugins.licensee) apply false
    alias(libs.plugins.roborazzi) apply false
}

tasks.register("clean") {
    delete(layout.buildDirectory)
}

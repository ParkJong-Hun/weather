package co.kr.parkjonghun.composemultiplatformtestairfield.uicore.navigation

import androidx.navigation.NavDeepLink
import androidx.navigation.navDeepLink

enum class AppDeepLinks(
    val deepLink: NavDeepLink,
) {
    Home(
        deepLink = navDeepLink {
            uriPattern = "custom://co.kr.parkjonghun.composemultiplatformtestairfield/"
        }
    )
}
package co.kr.parkjonghun.composemultiplatformtestairfield.uicore.navigation

import kotlinx.serialization.Serializable

// TODO: Need to Change so that it cannot be accessed directly from modules other than shared
// It can be Enum class ?
sealed interface AppPages : Page {
    override val route: String

    @Serializable
    data object Home : AppPages {
        override val route: String = "weather"
    }

    @Serializable
    data object Search : AppPages {
        override val route: String = "weather/search"
    }

    @Serializable
    data object License : AppPages {
        override val route: String = "weather/license"
    }
}
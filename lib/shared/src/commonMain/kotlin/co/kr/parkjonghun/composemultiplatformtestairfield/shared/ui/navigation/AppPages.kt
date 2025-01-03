package co.kr.parkjonghun.composemultiplatformtestairfield.shared.ui.navigation

sealed interface AppPages {
    val route: String

    data object Home : AppPages {
        override val route: String = "weather"
    }

    data object Search : AppPages {
        override val route: String = "weather/search"
    }

    data object License : AppPages {
        override val route: String = "weather/license"
    }
}
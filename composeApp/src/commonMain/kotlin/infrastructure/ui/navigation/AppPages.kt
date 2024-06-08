package infrastructure.ui.navigation

sealed interface AppPages {
    val route: String

    data object Home : AppPages {
        override val route: String = "weather"
    }

    data object Search : AppPages {
        override val route: String = "weather/search"
    }
}
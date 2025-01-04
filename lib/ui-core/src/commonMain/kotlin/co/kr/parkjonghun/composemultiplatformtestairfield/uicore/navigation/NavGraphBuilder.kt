package co.kr.parkjonghun.composemultiplatformtestairfield.uicore.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import kotlin.reflect.KType

fun NavGraphBuilder.composablePush(
    route: String,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    content: @Composable() (AnimatedContentScope.(NavBackStackEntry) -> Unit),
) = composable(
    route = route,
    arguments = arguments,
    deepLinks = deepLinks,
    enterTransition = pushIn(),
    exitTransition = pushOut(),
    popEnterTransition = pushIn(),
    popExitTransition = pushOut(),
    content = content,
)

inline fun <reified T : Any> NavGraphBuilder.composablePush(
    typeMap: Map<KType, NavType<*>> = emptyMap(),
    deepLinks: List<NavDeepLink> = emptyList(),
    noinline content: @Composable() (AnimatedContentScope.(NavBackStackEntry) -> Unit),
) = composable<T>(
    typeMap = typeMap,
    deepLinks = deepLinks,
    enterTransition = pushIn(),
    exitTransition = pushOut(),
    popEnterTransition = pushIn(),
    popExitTransition = pushOut(),
    content = content,
)
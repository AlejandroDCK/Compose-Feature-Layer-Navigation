package com.novastudio.composefeaturelayernavigation.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.novastudio.composefeaturelayernavigation.core.navigation.type.createNavType
import com.novastudio.composefeaturelayernavigation.feature_a.presentation.ScreenA
import com.novastudio.composefeaturelayernavigation.feature_b.presentation.ScreenB
import com.novastudio.composefeaturelayernavigation.home.presentation.HomeScreen
import kotlin.reflect.typeOf

@Composable
fun NavigationWrapper() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = HomeScreen) {
        composable<HomeScreen> {
            HomeScreen(
                navigateToA = {
                    navController.navigate(ScreenA)
                },
            )
        }
        composable<ScreenA> {
            ScreenA(
                navigateToB = { mobile ->
                    navController.navigate(ScreenB(mobile))
                },
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
        composable<ScreenB>(typeMap = mapOf(typeOf<Mobile>() to createNavType<Mobile>())) { backStackEntry ->
            val screenB: ScreenB = backStackEntry.toRoute()
            ScreenB(
                mobile = screenB.mobile,
                navigateToHome = {
                    navController.navigate(HomeScreen) {
                        popUpTo<HomeScreen> {
                            inclusive = true
                        }
                    }
                },
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
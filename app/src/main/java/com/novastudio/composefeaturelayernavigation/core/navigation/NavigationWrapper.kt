package com.novastudio.composefeaturelayernavigation.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.novastudio.composefeaturelayernavigation.feature_a.presentation.ScreenA
import com.novastudio.composefeaturelayernavigation.feature_b.presentation.ScreenB
import com.novastudio.composefeaturelayernavigation.home.presentation.HomeScreen
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.generated.NavGraphs
import com.ramcosta.composedestinations.generated.destinations.HomeScreenDestination
import com.ramcosta.composedestinations.generated.destinations.ScreenADestination
import com.ramcosta.composedestinations.generated.destinations.ScreenBDestination
import com.ramcosta.composedestinations.manualcomposablecalls.composable
import com.ramcosta.composedestinations.rememberNavHostEngine

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    val navHostEngine = rememberNavHostEngine()

    DestinationsNavHost(navController = navController, engine = navHostEngine, navGraph = NavGraphs.root) {

        composable(HomeScreenDestination) {
            HomeScreen {
                destinationsNavigator.navigate(ScreenADestination)
            }
        }

        composable(ScreenADestination) {
            ScreenA (navigateBack = destinationsNavigator::popBackStack){
                destinationsNavigator.navigate(ScreenBDestination(it))
            }
        }

        composable(ScreenBDestination) {
            val message = ScreenBDestination.argsFrom(navBackStackEntry.arguments).message
            ScreenB(message = message, navigateBack = destinationsNavigator::popBackStack) {
                destinationsNavigator.navigate(HomeScreenDestination)
            }
        }
    }

}
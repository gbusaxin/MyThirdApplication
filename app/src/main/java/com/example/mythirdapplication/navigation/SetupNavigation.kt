package com.example.mythirdapplication.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi


@ExperimentalFoundationApi
@ExperimentalAnimationApi
@ExperimentalCoilApi
@Composable
fun SetupNavigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = SetupScreens.Splash.route
    ) {
        composable(
            route = SetupScreens.Splash.route
        ) {
            TODO()
        }
        composable(
            route = SetupScreens.Welcome.route
        ) {
            TODO()
        }
        composable(
            route = SetupScreens.Home.route
        ) {
            TODO()
        }
        composable(
            route = SetupScreens.Chrome.route,
            arguments = listOf(navArgument(
                name = ARGUMENT_RESPONSE
            ) {
                type = NavType.StringType
            })
        ) {
            TODO()
        }
    }

}
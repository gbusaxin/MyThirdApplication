package com.example.mythirdapplication.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.example.mythirdapplication.presentation.screens.HomeScreen
import com.example.mythirdapplication.presentation.screens.chrome.ChromeScreen
import com.example.mythirdapplication.presentation.screens.splash.SplashScreen
import com.example.mythirdapplication.presentation.screens.welcome.WelcomeScreen
import com.google.accompanist.pager.ExperimentalPagerApi


@ExperimentalMaterialApi
@ExperimentalPagerApi
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
            SplashScreen(navController = navController)
        }
        composable(
            route = SetupScreens.Welcome.route
        ) {
            WelcomeScreen(navController = navController)
        }
        composable(
            route = SetupScreens.Home.route
        ) {
            HomeScreen()
        }
        composable(
            route = SetupScreens.Chrome.route,
            arguments = listOf(navArgument(
                name = ARGUMENT_RESPONSE
            ) {
                type = NavType.StringType
            })
        ) {
            ChromeScreen(
                navController = navController
            )
        }
    }

}
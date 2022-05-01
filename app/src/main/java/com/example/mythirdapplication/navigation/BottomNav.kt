package com.example.mythirdapplication.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalFoundationApi
@ExperimentalCoilApi
@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun BottomNav(
    navController:NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavigationScreens.News.route
    ){
        composable(
            route = BottomNavigationScreens.News.route
        ){
            TODO()
        }
        composable(
            route = BottomNavigationScreens.Stadiums.route
        ){
            TODO()
        }
        composable(
            route = BottomNavigationScreens.Tourney.route
        ){
            TODO()
        }
    }
}
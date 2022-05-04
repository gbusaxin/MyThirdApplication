package com.example.mythirdapplication.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.annotation.ExperimentalCoilApi
import com.example.mythirdapplication.presentation.screens.home.news.NewsScreen
import com.example.mythirdapplication.presentation.screens.home.stadium.StadiumScreen
import com.example.mythirdapplication.presentation.screens.home.tourney.TourneyScreen
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
            NewsScreen()
        }
        composable(
            route = BottomNavigationScreens.Stadiums.route
        ){
            StadiumScreen()
        }
        composable(
            route = BottomNavigationScreens.Tourney.route
        ){
            TourneyScreen()
        }
    }
}
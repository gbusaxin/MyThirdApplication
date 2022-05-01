package com.example.mythirdapplication.navigation

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationScreens(
    var route: String,
    val icon: ImageVector,
    val title: String) {

    object News : BottomNavigationScreens(
        route = "news",
        title = "Новости",
        icon = Icons.Filled.Home
    )

    object Stadiums : BottomNavigationScreens(
        route = "matches",
        title = "Матчи",
        icon = Icons.Filled.Info
    )

    object Tourney : BottomNavigationScreens(
        route = "groups",
        title = "Группы",
        icon = Icons.Filled.Person
    )

}
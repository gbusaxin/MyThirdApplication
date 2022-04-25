package com.example.mythirdapplication.navigation

const val ARGUMENT_RESPONSE = "server_response"

sealed class SetupScreens(val route: String) {

    object Splash : SetupScreens(route = "splash_screen")

    object Welcome : SetupScreens(route = "welcome_screen")

    object Home : SetupScreens(route = "home_screen")

    object Chrome : SetupScreens("chrome_screen/{$ARGUMENT_RESPONSE}") {
        fun passResponse(response: String): String {
            return this.route.replace(oldValue = "{$ARGUMENT_RESPONSE}", newValue = response)
        }
    }
}
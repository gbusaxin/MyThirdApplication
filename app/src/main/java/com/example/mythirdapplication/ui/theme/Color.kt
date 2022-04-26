package com.example.mythirdapplication.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)


val DarkOrange = Color(0xffff7700)
val NightOrange = Color(0xffcc7000)
val LightOrange = Color(0xffffa04d)
val DarkGray = Color(0xFF696969)
val LightGray = Color(0xFFD3D3D3)

val Red1 = Color(0xffff0000)
val Red2 = Color(0xff800000)

val Blue1 = Color(0xff23abed)
val Blue2 = Color(0xff70bee4)

val Yellow1 = Color(0xffffff00)
val Yellow2 = Color(0xffcccc00)

val Colors.mainBackgroundColor
    @Composable
    get() = if (isSystemInDarkTheme()) Color.Black else LightGray

val Colors.textColor
    @Composable
    get() = if (isSystemInDarkTheme()) Color.White else Color.Black

val Colors.secondaryTextColor
    @Composable
    get() = if (isSystemInDarkTheme()) Color.LightGray else Color.DarkGray

val Colors.buttonColor
    @Composable
    get() = if (isSystemInDarkTheme()) DarkGray else LightGray.copy(alpha = 0.3f)

val Colors.inactiveIndicatorColor
    @Composable
    get() = if (isSystemInDarkTheme()) Purple700 else Purple500

val Colors.activeIndicatorColor
    @Composable
    get() = if (isSystemInDarkTheme()) Purple200 else Purple200

val Colors.cardColor
    @Composable
    get() = if (isSystemInDarkTheme()) NightOrange else DarkOrange

val Colors.appBarColor
    @Composable
    get() = if (isSystemInDarkTheme()) Purple700 else Purple500

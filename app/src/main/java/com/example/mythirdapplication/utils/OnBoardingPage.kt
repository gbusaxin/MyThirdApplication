package com.example.mythirdapplication.utils

import androidx.annotation.DrawableRes
import com.example.mythirdapplication.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String
) {
    object FirstPage : OnBoardingPage(
        image = R.drawable.ic_handshake,
        title = "Добро пожаловать!"
    )

    object LastPage : OnBoardingPage(
        image = R.drawable.ic_door,
        title = "Нажмите кнопку для того чтобы продолжить..."
    )
}

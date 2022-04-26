package com.example.mythirdapplication.presentation.screens.welcome

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.mythirdapplication.navigation.SetupScreens
import com.example.mythirdapplication.ui.theme.*
import com.example.mythirdapplication.utils.OnBoardingPage
import com.google.accompanist.pager.*

@ExperimentalPagerApi
@Composable
fun WelcomeScreen(
    navController: NavHostController,
    viewModel: WelcomeViewModel = hiltViewModel()
) {
    val pages = listOf(
        OnBoardingPage.FirstPage,
        OnBoardingPage.LastPage
    )

    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.mainBackgroundColor)
    ) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            state = pagerState,
            count = pages.size,
            verticalAlignment = Alignment.Top
        ) {
            PagerScreen(page = pages[it])
        }
        HorizontalPagerIndicator(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally),
            pagerState = pagerState,
            inactiveColor = MaterialTheme.colors.inactiveIndicatorColor,
            activeColor = MaterialTheme.colors.activeIndicatorColor,
            indicatorWidth = PAGGING_INDICATOR_WIDTH,
            spacing = PAGGING_INDICATOR_SPACING
        )
        ButtonReady(
            pagerState = pagerState,
            modifier = Modifier.weight(1f)
        ) {
            navController.popBackStack()
            navController.navigate(
                route = SetupScreens.Home.route
            )
            viewModel.setOnBoardingState(completed = true)
        }
    }
}

@Composable
fun PagerScreen(
    page: OnBoardingPage
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .height(64.dp)
                .width(64.dp)
                .fillMaxHeight(0.7f)
                .padding(horizontal = SMALL_PADDING),
            painter = painterResource(id = page.image),
            contentDescription = "image"
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = SMALL_PADDING),
            text = page.title,
            color = MaterialTheme.colors.textColor,
            fontSize = MaterialTheme.typography.h5.fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

    }
}

@ExperimentalPagerApi
@Composable
fun ButtonReady(
    pagerState: PagerState,
    modifier: Modifier,
    onClick: () -> Unit
) {

    Row(
        modifier = modifier.padding(horizontal = EXTRA_LARGE_PADDING),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = pagerState.currentPage == 1
        ) {
            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.buttonColor,
                    contentColor = MaterialTheme.colors.textColor
                )
            ) {
                Text(text = "Готов.")
            }
        }
    }
}
package com.example.mythirdapplication.presentation.screens.home.news

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mythirdapplication.domain.models.NewsDTO
import com.example.mythirdapplication.ui.theme.SMALL_PADDING
import com.example.mythirdapplication.ui.theme.Shapes
import java.util.*

@ExperimentalMaterialApi
@Composable
fun NewsScreen(
    viewModel: NewsViewModel = hiltViewModel()
) {

    val newsList: List<NewsDTO> by viewModel.newsList.collectAsState(initial = Collections.emptyList())

    LazyColumn(
        modifier = Modifier
            .background(if (isSystemInDarkTheme()) Color.Black else Color.White),
        contentPadding = PaddingValues(all = SMALL_PADDING),
        verticalArrangement = Arrangement.spacedBy(SMALL_PADDING)
    ) {
        items(
            items = newsList,
            key = { news -> news.id }
        ) {
            it?.let {
                ExpandableCard(
                    news = it
                )
            }
        }
    }

}

@ExperimentalMaterialApi
@Composable
fun ExpandableCard(
    news: NewsDTO
) {
    var isExpandedState by remember {
        mutableStateOf(false)
    }
    val rotationState by animateFloatAsState(targetValue = if (isExpandedState) 180f else 0f)
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .background(if (isSystemInDarkTheme()) Color.DarkGray else Color.LightGray)
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = Shapes.medium,
        border = BorderStroke(
            width = 1.dp,
            color = (if (isSystemInDarkTheme()) Color.LightGray else Color.DarkGray)
        ),
        onClick = {
            isExpandedState = !isExpandedState
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(SMALL_PADDING)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                news.title?.let {
                    Text(
                        modifier = Modifier.weight(6f),
                        text = it,
                        fontSize = MaterialTheme.typography.h6.fontSize,
                        fontWeight = FontWeight.Bold
                    )
                }
                IconButton(
                    modifier = Modifier
                        .weight(1f)
                        .alpha(ContentAlpha.medium)
                        .rotate(rotationState),
                    onClick = {
                        isExpandedState = !isExpandedState
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "icon"
                    )
                }
            }//row
            if (isExpandedState) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    news.body?.let {
                        Text(
                            text = it,
                            fontSize = MaterialTheme.typography.subtitle1.fontSize,
                            fontWeight = FontWeight.Normal
                        )
                    }
                }
            }
        }//column
    }//card
}
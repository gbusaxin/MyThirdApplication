package com.example.mythirdapplication.presentation.screens.home.tourney

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.mythirdapplication.R
import com.example.mythirdapplication.presentation.screens.home.stadium.StadiumItem
import com.example.mythirdapplication.ui.theme.MEDIUM_PADDING
import com.example.mythirdapplication.ui.theme.SMALL_PADDING
import com.example.mythirdapplication.ui.theme.Shapes
import java.util.*

@ExperimentalCoilApi
@Composable
fun TourneyScreen(
    viewModel: TourneyViewModel = hiltViewModel()
) {

    val tourneys by viewModel.tourneysListState.collectAsState(initial = Collections.emptyList())

    LazyColumn(
        modifier = Modifier
            .background(if (isSystemInDarkTheme()) Color.Black else Color.White),
        contentPadding = PaddingValues(all = SMALL_PADDING),
        verticalArrangement = Arrangement.spacedBy(SMALL_PADDING)
    ) {
        items(
            items = tourneys,
            key = { tourney -> tourney.id }
        ) {
            it?.let { tourney ->
                TourneyItem(
                    enemy1 = tourney.enemy1?:"",
                    enemy2 = tourney.enemy2?:"",
                    image1 = tourney.image1?:"",
                    image2 = tourney.image2?:"",
                    date = tourney.date?:"",
                    result = tourney.result?:""
                )
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun TourneyItem(
    enemy1: String,
    enemy2: String,
    image1: String,
    image2: String,
    date: String,
    result: String
) {

    val painter1 = rememberImagePainter(data = image1) {
        placeholder(R.drawable.ic_placeholder)
        error(R.drawable.ic_error)
    }
    val painter2 = rememberImagePainter(data = image2) {
        placeholder(R.drawable.ic_placeholder)
        error(R.drawable.ic_error)
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        shape = Shapes.medium,
        border = BorderStroke(
            width = 1.dp,
            color = (if (isSystemInDarkTheme()) Color.LightGray else Color.DarkGray)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp),
                        painter = painter1,
                        contentDescription = "image"
                    )
                    Text(
                        text = enemy1,
                        fontSize = MaterialTheme.typography.h6.fontSize,
                        fontWeight = FontWeight.Bold
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp),
                        painter = painter2,
                        contentDescription = "image"
                    )
                    Text(
                        text = enemy2,
                        fontSize = MaterialTheme.typography.h6.fontSize,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Text(
                modifier = Modifier.padding(MEDIUM_PADDING),
                text = date,
                fontSize = MaterialTheme.typography.subtitle1.fontSize,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                text = result,
                fontSize = MaterialTheme.typography.h5.fontSize,
                fontWeight = FontWeight.Bold
            )
        }
    }

}
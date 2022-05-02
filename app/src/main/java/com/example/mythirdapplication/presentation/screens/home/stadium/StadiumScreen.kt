package com.example.mythirdapplication.presentation.screens.home.stadium

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.mythirdapplication.R
import com.example.mythirdapplication.domain.models.StadiumDTO
import com.example.mythirdapplication.presentation.screens.home.news.ExpandableCard
import com.example.mythirdapplication.ui.theme.MEDIUM_PADDING
import com.example.mythirdapplication.ui.theme.SMALL_PADDING
import com.example.mythirdapplication.ui.theme.Shapes
import java.util.*

@ExperimentalCoilApi
@Composable
fun StadiumScreen(
    viewModel: StadiumViewModel = hiltViewModel()
) {
    val stadiumsList by viewModel.stadiumsListState.collectAsState(initial = Collections.emptyList())

    LazyColumn(
        modifier = Modifier
            .background(if (isSystemInDarkTheme()) Color.Black else Color.White),
        contentPadding = PaddingValues(all = SMALL_PADDING),
        verticalArrangement = Arrangement.spacedBy(SMALL_PADDING)
    ) {
        items(
            items = stadiumsList,
            key = { stadium -> stadium.id }
        ) {
            it?.let { stadium ->
                StadiumItem(
                    name = stadium.name?:"",
                    capacity = stadium.capacity?:"",
                    image = stadium.image?:"",
                    city = stadium.city?:"",
                    country = stadium.country?:""
                )
            }
        }
    }

}

@ExperimentalCoilApi
@Composable
fun StadiumItem(
    name: String,
    capacity: String,
    image: String,
    city:String,
    country:String
) {

    val painter = rememberImagePainter(data = image) {
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
                .padding(MEDIUM_PADDING)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                painter = painter,
                contentDescription = "image"
            )
            Text(
                text = name,
                fontSize = MaterialTheme.typography.h6.fontSize,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = country,
                fontSize = MaterialTheme.typography.h6.fontSize,
                fontWeight = FontWeight.Bold
            )
            Row {
                Text(
                    modifier = Modifier.weight(1f),
                    text = city,
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = capacity,
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}
package com.example.marsjourneyapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.marsjourneyapp.R
import com.example.marsjourneyapp.model.roverUiModelList

/**
 * Created by AralBenli on 1.07.2023.
 */


@Composable
fun RoverList(
    onClick: (roverName: String) -> Unit
) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn {
            items(count = roverUiModelList.size, itemContent = { index ->
                Rover(
                    name = roverUiModelList[index].name,
                    img = roverUiModelList[index].image,
                    landingDate = roverUiModelList[index].landingDate,
                    distance = roverUiModelList[index].distance,
                    onClick = onClick
                )
            })

        }

    }

}


@Composable
fun Rover(
    name: String,
    img: Int,
    landingDate: String,
    distance: String,
    onClick: (roverName: String) -> Unit
) {
    Card(modifier = Modifier.padding(16.dp).clickable { onClick(name) }) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = name,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
            Image(
                painter = painterResource(id = img),
                contentDescription = null
            )
            Text(text = "Credit : NASA/JPL", fontSize = 8.sp)
            Text(text = "Landing date: $landingDate", fontSize = 12.sp)
            Text(text = "Distance travelled: $distance", fontSize = 12.sp)
        }
    }
}

@Preview
@Composable
fun RoverPreview() {
    Rover("Perseverance",
        R.drawable.perseverance,
        "18 February 2021",
        "12.56km") {}
}
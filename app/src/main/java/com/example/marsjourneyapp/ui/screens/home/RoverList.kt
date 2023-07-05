package com.example.marsjourneyapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
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
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .clickable { onClick(name) },
        //backgroundColor = Color.LightGray,
        shape = RoundedCornerShape(40.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center
                )
                Box(
                    modifier = Modifier
                        .size(350.dp) // Set a fixed size for the image
                        .clip(RoundedCornerShape(16.dp)) // Apply rounded corners to the image
                ) {
                    Image(
                        painter = painterResource(id = img),
                        contentDescription = null,
                        contentScale = ContentScale.Crop, // Adjust the scaling as needed
                        modifier = Modifier
                            .fillMaxSize()
                            .aspectRatio(1f)
                    )
                }
                Text(text = "Credit : NASA/JPL", fontSize = 8.sp)
                Text(text = "Landing date: $landingDate", fontSize = 12.sp)
                Text(text = "Distance travelled: $distance", fontSize = 12.sp)
            }
        }
    }
}

@Preview
@Composable
fun RoverPreview() {
    Rover(
        "Perseverance",
        R.drawable.perseverance,
        "18 February 2021",
        "12.56km"
    ) {}
}
package com.example.marsjourneyapp.ui.screens.photo

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.marsjourneyapp.R
import com.example.marsjourneyapp.model.RoverPhotoUiModel

/**
 * Created by AralBenli on 5.07.2023.
 */

@Composable
fun PhotoList(
    roverPhotoUiModelList: List<RoverPhotoUiModel>
) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn {
            items(
                count = roverPhotoUiModelList.size,
                itemContent = { index ->
                    Photo(roverPhotoUiModel = roverPhotoUiModelList[index])
                }
            )
        }
    }
}

@Composable
fun Photo(
    roverPhotoUiModel: RoverPhotoUiModel
) {
    var isFullscreen by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.padding(16.dp),
        shape = RoundedCornerShape(40.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = roverPhotoUiModel.roverName,
                modifier = Modifier.padding(16.dp)
            )

            Box(
                modifier = Modifier
                    .clickable { isFullscreen = true }
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(40.dp))
            ) {
                AsyncImage(
                    model = roverPhotoUiModel.imgSrc,
                    contentDescription = "rover photo",
                    modifier = Modifier.fillMaxSize()
                )
            }

            Text(text = stringResource(id = R.string.sol, roverPhotoUiModel.sol))
            Text(text = stringResource(id = R.string.earth_date, roverPhotoUiModel.earthDate))
            Text(text = roverPhotoUiModel.cameraFullName)
        }
    }

    if (isFullscreen) {
        Dialog(
            onDismissRequest = { isFullscreen = false },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            )
        ) {
            Box(
                modifier = Modifier
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onPress = {},
                            onDoubleTap = {},
                            onTap = { isFullscreen = false }
                        )
                    }
                    .fillMaxWidth()
                    .fillMaxHeight(0.9f),
                contentAlignment = Alignment.Center,
            ) {
                Image(
                    contentScale = ContentScale.Crop, // Adjust the scaling as needed
                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current)
                            .data(data = roverPhotoUiModel.imgSrc)
                            .apply(block = fun ImageRequest.Builder.() {
                                crossfade(true)
                            }).build()
                    ),
                    contentDescription = "rover photo",
                    modifier = Modifier
                        .fillMaxSize()
                        .aspectRatio(1f)
                        .scale(1.5f)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PhotoPreview() {
    Photo(
        roverPhotoUiModel = RoverPhotoUiModel(
            id = 4,
            roverName = "Curiosity",
            imgSrc = "https://domain.com",
            sol = "34",
            earthDate = "2021-03-05",
            cameraFullName = "Mast Camera Zoom - Right"
        )
    )
}
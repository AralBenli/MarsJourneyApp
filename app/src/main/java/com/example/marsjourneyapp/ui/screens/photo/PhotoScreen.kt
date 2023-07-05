package com.example.marsjourneyapp.ui.screens.photo

import android.util.Log
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.marsjourneyapp.model.RoverPhotoUiState
import com.example.marsjourneyapp.ui.statescreens.error.Error
import com.example.marsjourneyapp.ui.statescreens.loading.Loading

/**
 * Created by AralBenli on 5.07.2023.
 */
@Composable
fun PhotoScreen(
    roverName: String?,
    sol: String?,
    marsRoverPhotoViewModel: MarsRoverPhotoViewModel
) {
    Log.d("PhotoScreen", "Initializing PhotoScreen")

    val viewState by marsRoverPhotoViewModel.roverPhotoUiState.collectAsStateWithLifecycle()

    if (roverName != null && sol != null) {
        LaunchedEffect(Unit) {
            marsRoverPhotoViewModel.getMarsRoverPhoto(roverName, sol)
        }
        when (val roverPhotoUiState = viewState) {
            is RoverPhotoUiState.Error -> Error()
            is RoverPhotoUiState.Loading -> Loading()
            is RoverPhotoUiState.Success -> if (!roverPhotoUiState.roverPhotoUiModelList.isNullOrEmpty()) {
                PhotoList(
                    roverPhotoUiModelList = roverPhotoUiState.roverPhotoUiModelList
                )
            } else {
                Text("No data available")
            }
        }
    }
}

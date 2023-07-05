package com.example.marsjourneyapp.ui.screens.detail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.marsjourneyapp.model.RoverManifestUiState
import com.example.marsjourneyapp.ui.statescreens.error.Error
import com.example.marsjourneyapp.ui.statescreens.loading.Loading
import com.example.marsjourneyapp.ui.screens.manifestlist.ManifestList

/**
 * Created by AralBenli on 2.07.2023.
 */

@Composable
fun ManifestScreen(
    roverName: String?,
    marsRoverManifestViewModel: MarsRoverManifestViewModel,
    onClick: (roverName: String, sol: String) -> Unit
) {
    val viewState by marsRoverManifestViewModel.roverManifestUiState.collectAsStateWithLifecycle()

    if (roverName != null) {
        LaunchedEffect(Unit) {
            marsRoverManifestViewModel.getMarsRoverManifest(roverName)
        }
        when (val roverManifestUiState = viewState) {
            is RoverManifestUiState.Error -> Error()
            is RoverManifestUiState.Loading -> Loading()
            is RoverManifestUiState.Success -> {
                val roverManifestUiModelList = roverManifestUiState.roverManifestUiModelList
                if (roverManifestUiModelList.isNotEmpty()) {
                    ManifestList(
                        roverManifestUiModelList = roverManifestUiModelList,
                        roverName,
                        onClick
                    )
                } else {
                    Text("No data available")
                }
            }
        }
    }
}



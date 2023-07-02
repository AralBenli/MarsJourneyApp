package com.example.marsjourneyapp.repo

import com.example.marsjourneyapp.api.MarsRoverManifestService
import com.example.marsjourneyapp.model.RoverManifestUiState
import com.example.marsjourneyapp.model.toUiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by AralBenli on 2.07.2023.
 */

class MarsRoverManifestRepo @Inject constructor(
    private val marsRoverManifestService: MarsRoverManifestService
){
    fun getMarsRoverManifest(roverName: String) : Flow<RoverManifestUiState> = flow {
        try {
            toUiModel(
                marsRoverManifestService.getMarsRoverManifest(
                    roverName.lowercase()
                )
            )

        }catch (throwable : Throwable){
            emit(RoverManifestUiState.Error)
        }
    }
}
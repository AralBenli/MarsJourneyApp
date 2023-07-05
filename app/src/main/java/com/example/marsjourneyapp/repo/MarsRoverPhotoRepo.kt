package com.example.marsjourneyapp.repo

import com.example.marsjourneyapp.api.MarsRoverPhotoService
import com.example.marsjourneyapp.model.RoverPhotoUiModel
import com.example.marsjourneyapp.model.RoverPhotoUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by AralBenli on 5.07.2023.
 */

class MarsRoverPhotoRepo @Inject constructor(
    private val marsRoverPhotoService: MarsRoverPhotoService
) {

    fun getMarsRoverPhoto(roverName: String, sol: String) : Flow<RoverPhotoUiState> = flow {
        try {
            val networkResult = marsRoverPhotoService.getMarsRoverPhotos(roverName, sol)
            emit(RoverPhotoUiState.Success(networkResult.photos.map { photo ->
                RoverPhotoUiModel(
                    id = photo.id,
                    roverName = photo.rover.name,
                    imgSrc = photo.imgSrc,
                    sol = photo.sol.toString(),
                    earthDate = photo.earthDate,
                    cameraFullName = photo.camera.fullName
                )
            }))

        } catch (throwable: Throwable) {
            emit(RoverPhotoUiState.Error)
        }
    }
}

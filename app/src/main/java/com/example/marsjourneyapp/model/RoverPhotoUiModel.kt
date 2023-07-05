package com.example.marsjourneyapp.model

/**
 * Created by AralBenli on 5.07.2023.
 */



sealed class RoverPhotoUiState {
    data class Success(
        val roverPhotoUiModelList: List<RoverPhotoUiModel>
    ) : RoverPhotoUiState()
    object Loading : RoverPhotoUiState()
    object Error : RoverPhotoUiState()
}


data class RoverPhotoUiModel(
    val id: Int,
    val roverName: String,
    val imgSrc: String,
    val sol: String,
    val earthDate: String,
    val cameraFullName: String
)

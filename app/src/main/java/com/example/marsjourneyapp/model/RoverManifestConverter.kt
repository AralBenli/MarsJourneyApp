package com.example.marsjourneyapp.model

import com.example.marsjourneyapp.api.model.RoverManifestRemoteModel

/**
 * Created by AralBenli on 2.07.2023.
 */
fun toUiModel(remoteModel: RoverManifestRemoteModel) : RoverManifestUiState =
    RoverManifestUiState.Success(remoteModel.photoManifest.photos.map { photo ->
        RoverManifestUiModel(
            sol = photo.sol.toString(),
            earthDate = photo.earthDate,
            photoNumber = photo.totalPhotos.toString()
        )
    }.sorted())
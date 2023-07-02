package com.example.marsjourneyapp.api.model

import com.google.gson.annotations.SerializedName

/**
 * Created by AralBenli on 2.07.2023.
 */

data class RoverManifestRemoteModel(
    @field:SerializedName("photo_manifest")
    val photoManifest: PhotoManifestRemoteModel
)
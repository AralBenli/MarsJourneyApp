package com.example.marsjourneyapp.api.model

import com.google.gson.annotations.SerializedName


/**
 * Created by AralBenli on 5.07.2023.
 */

data class PhotoRemoteModel(
    val camera: CameraRemoteModel,
    @SerializedName("earth_date")
    val earthDate: String,
    val id: Int,
    @SerializedName("img_src")
    val imgSrc: String,
    val rover: RoverRemoteModel,
    val sol: Int
)
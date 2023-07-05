package com.example.marsjourneyapp.api.model

import com.google.gson.annotations.SerializedName

/**
 * Created by AralBenli on 5.07.2023.
 */

data class CameraRemoteModel(
    @field:SerializedName("full_name")
    val fullName: String,
    @field:SerializedName("rover_id")
    val roverId: Int,
    val id: Int,
    val name: String

)
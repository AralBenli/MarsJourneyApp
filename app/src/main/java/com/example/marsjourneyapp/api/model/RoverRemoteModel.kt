package com.example.marsjourneyapp.api.model

import com.google.gson.annotations.SerializedName

/**
 * Created by AralBenli on 5.07.2023.
 */

data class RoverRemoteModel (
    val id : Int ,
    @SerializedName("landing_date")
    val landingDate : String,
    @SerializedName("launch_date")
    val launchDate : String,
    val name : String ,
    val status : String
)
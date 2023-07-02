package com.example.marsjourneyapp.ui.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

/**
 * Created by AralBenli on 2.07.2023.
 */

@Composable
fun ManifestScreen(
    roverName: String?
){
    Text(text = "Manifest Screen $roverName")

}


@Preview
@Composable
fun ManifestScreenPreview(){
    ManifestScreen("Perseverance")
}
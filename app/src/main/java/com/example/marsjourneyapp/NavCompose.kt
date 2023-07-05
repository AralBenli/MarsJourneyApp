package com.example.marsjourneyapp

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.marsjourneyapp.nav.Action
import com.example.marsjourneyapp.nav.Destinations.Home
import com.example.marsjourneyapp.nav.Destinations.Manifest
import com.example.marsjourneyapp.nav.Destinations.Photo
import com.example.marsjourneyapp.ui.screens.detail.ManifestScreen
import com.example.marsjourneyapp.ui.screens.RoverList
import com.example.marsjourneyapp.ui.screens.photo.PhotoScreen
import com.example.marsjourneyapp.ui.theme.MarsJourneyApp

/**
 * Created by AralBenli on 2.07.2023.
 */

@Composable
fun NavCompose() {
    val navController = rememberNavController()
    val actions = remember(navController) { Action(navController) }

    MarsJourneyApp {
        NavHost(navController = navController, startDestination = Home) {
            composable(Home) {
                RoverList() { roverName ->
                    actions.manifest(roverName)
                }
            }
            composable(Manifest) { backStackEntry ->
                val roverName = backStackEntry.arguments?.getString("roverName")
                Log.d("NavCompose", "Manifest - Rover Name: $roverName")

                ManifestScreen(
                    roverName = roverName,
                    marsRoverManifestViewModel = hiltViewModel(),
                    onClick = { roverName, sol ->
                        actions.photo(roverName, sol)
                    }
                )
            }
            composable(Photo) { backStackEntry ->
                val roverName = backStackEntry.arguments?.getString("roverName")
                val sol = backStackEntry.arguments?.getString("sol")
                Log.d("NavCompose", "Photo - Rover Name: $roverName, Sol: $sol")

                PhotoScreen(
                    roverName = roverName,
                    sol = sol,
                    marsRoverPhotoViewModel = hiltViewModel()
                )
            }
        }
    }
}

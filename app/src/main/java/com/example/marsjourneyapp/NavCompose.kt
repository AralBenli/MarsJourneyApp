package com.example.marsjourneyapp

import android.net.wifi.hotspot2.pps.HomeSp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.marsjourneyapp.nav.Action
import com.example.marsjourneyapp.nav.Destinations.Home
import com.example.marsjourneyapp.nav.Destinations.Manifest
import com.example.marsjourneyapp.ui.screens.ManifestScreen
import com.example.marsjourneyapp.ui.screens.RoverList
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
                ManifestScreen(
                    roverName = backStackEntry.arguments?.getString("roverName")
                )
            }
        }
    }
}
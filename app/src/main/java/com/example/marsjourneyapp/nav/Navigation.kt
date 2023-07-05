package com.example.marsjourneyapp.nav

import androidx.navigation.NavController
import com.example.marsjourneyapp.nav.Destinations.Home

/**
 * Created by AralBenli on 2.07.2023.
 */

object Destinations {
    const val Home = "home"
    const val Manifest = "manifest/{roverName}"
    const val Photo = "photo/{roverName}?sol={sol}"
}

class Action(navController: NavController) {
    val home: () -> Unit = { navController.navigate(Home) }
    val manifest: (roverName: String) -> Unit =
        { roverName ->
            navController.navigate("manifest/${roverName}")
        }
    val photo: (roverName: String, sol: String) -> Unit =
        { roverName , sol->
            navController.navigate("photo/${roverName}?sol=${sol}")
        }
}

package com.example.marsjourneyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.marsjourneyapp.ui.screens.RoverList
import com.example.marsjourneyapp.ui.theme.MarsJourneyApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarsJourneyApp {
                NavCompose()
            }
        }
    }
}


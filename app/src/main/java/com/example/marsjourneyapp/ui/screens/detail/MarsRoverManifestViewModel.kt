package com.example.marsjourneyapp.ui.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marsjourneyapp.model.RoverManifestUiState
import com.example.marsjourneyapp.repo.MarsRoverManifestRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by AralBenli on 3.07.2023.
 */

@HiltViewModel
class MarsRoverManifestViewModel @Inject constructor(
    private val marsRoverManifestRepo: MarsRoverManifestRepo
): ViewModel() {


    private val _roverManifestUiState : MutableStateFlow<RoverManifestUiState> = MutableStateFlow(RoverManifestUiState.Loading)
    val roverManifestUiState : StateFlow<RoverManifestUiState>
    get() = _roverManifestUiState



    fun getMarsRoverManifest(roverName : String){
        viewModelScope.launch {
            _roverManifestUiState.value = RoverManifestUiState.Loading
            marsRoverManifestRepo.getMarsRoverManifest(roverName).collect{
                _roverManifestUiState.value = it

            }
        }
    }
}


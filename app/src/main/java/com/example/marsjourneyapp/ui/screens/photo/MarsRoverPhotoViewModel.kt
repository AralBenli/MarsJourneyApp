package com.example.marsjourneyapp.ui.screens.photo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marsjourneyapp.model.RoverPhotoUiState
import com.example.marsjourneyapp.repo.MarsRoverPhotoRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by AralBenli on 5.07.2023.
 */

@HiltViewModel
class MarsRoverPhotoViewModel @Inject constructor(
    private val marsRoverPhotoRepo: MarsRoverPhotoRepo
) : ViewModel() {

    private val _roverPhotoUiState: MutableStateFlow<RoverPhotoUiState> =
        MutableStateFlow(RoverPhotoUiState.Loading)

    val roverPhotoUiState: StateFlow<RoverPhotoUiState>
        get() = _roverPhotoUiState

    fun getMarsRoverPhoto(roverName : String, sol: String) {
        viewModelScope.launch {
            _roverPhotoUiState.value = RoverPhotoUiState.Loading
            marsRoverPhotoRepo.getMarsRoverPhoto(roverName, sol).collect {
                _roverPhotoUiState.value = it
            }
        }
    }
}
package com.example.marsjourneyapp.ui.statescreens.error

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.marsjourneyapp.R

/**
 * Created by AralBenli on 3.07.2023.
 */

@Composable
fun Error (){
    Box(
        modifier = Modifier.fillMaxSize().fillMaxHeight(),
        contentAlignment = Alignment.Center
    ){
        Text(text = stringResource(id = R.string.error))
    }

}


@Composable
@Preview
fun ErrorPreview (){
    Error()
}


package com.example.marsjourneyapp.ui.statescreens.loading

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.marsjourneyapp.R

/**
 * Created by AralBenli on 5.07.2023.
 */
@Composable
fun Loading (){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        CircularProgressIndicator()
        Text(text = stringResource(id = R.string.loading))
    }

}


@Composable
@Preview
fun LoadingPreview (){
    Loading ()
}
package com.example.marsjourneyapp.ui.screens.manifestlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.marsjourneyapp.R
import com.example.marsjourneyapp.model.RoverManifestUiModel

/**
 * Created by AralBenli on 5.07.2023.
 */


@Composable
fun ManifestList(
    roverManifestUiModelList: List<RoverManifestUiModel>,
    roverName: String,
    onClick: (roverName: String, sol: String) -> Unit
) {
    Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(count = roverManifestUiModelList.size, itemContent = { index ->
                Manifest(
                    roverManifestUiModel = roverManifestUiModelList[index],
                    roverName,
                    onClick
                )
            })
        }
    }

}


@Composable
fun Manifest(
    roverManifestUiModel: RoverManifestUiModel,
    roverName: String,
    onClick: (roverName: String, sol: String) -> Unit
) {
    Card(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .clickable {
            onClick(roverName, roverManifestUiModel.sol)
        }) {
        Column(Modifier.padding(16.dp)) {
            Text(text = stringResource(id = R.string.sol, roverManifestUiModel.sol))
            Text(text = stringResource(id = R.string.earth_date, roverManifestUiModel.earthDate))
            Text(
                text = stringResource(
                    id = R.string.number_of_photo,
                    roverManifestUiModel.photoNumber
                )
            )
        }
    }
}

@Preview
@Composable
fun ManifestListPreview() {
    Manifest(roverManifestUiModel = RoverManifestUiModel("4", "2021-03-05", "34"),
        "",
        onClick = { _, _ -> })

}
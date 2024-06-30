package com.pixelcarrot.broccoli.feature.spotify.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pixelcarrot.broccoli.feature.spotify.viewmodel.SpotifyViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpotifyScreen(viewModel: SpotifyViewModel) {

    val steps by viewModel.steps.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Spotify Data") }
            )
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                when (steps.size) {
                    0 -> {
                        Button(onClick = {
                            viewModel.fetchAllSongs()
                        }) {
                            Text("Step 1: Fetch All Songs")
                        }
                    }

                    1 -> {
                        Button(onClick = {
                            viewModel.fetchAllStoredSongs()
                        }) {
                            Text("Step 2: Fetch Stored Songs")
                        }
                    }

                    2 -> {
                        Button(onClick = {
                            viewModel.fetchAllStoredAlbums()
                        }) {
                            Text("Step 3: Fetch Stored Albums")
                        }
                    }

                    3 -> {
                        Button(onClick = {
                            viewModel.fetchSongsByAlbumId("3hA2oZbZwHU8tSPBFIZhFr")
                        }) {
                            Text("Step 4: Fetch Songs by Album ID")
                        }
                    }
                }
                steps.forEach { step ->
                    Text(step)
                }
            }
        }
    }
}

package com.pixelcarrot.broccoli.feature.spotify.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pixelcarrot.broccoli.feature.spotify.viewmodel.SpotifyViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpotifyScreen(viewModel: SpotifyViewModel) {

    val data = viewModel.songsState.collectAsState().value

    LaunchedEffect(Unit) {
        viewModel.loadAllSongs()
    }

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
            Text(
                modifier = Modifier
                    .padding(16.dp),
                text = "Song count: ${data?.size}"
            )
        }
    }
}

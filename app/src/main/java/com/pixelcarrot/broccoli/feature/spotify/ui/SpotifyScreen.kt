package com.pixelcarrot.broccoli.feature.spotify.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pixelcarrot.broccoli.feature.spotify.viewmodel.SpotifyViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpotifyScreen(viewModel: SpotifyViewModel) {

    val songsState by viewModel.songsState.collectAsState()
    val albumsState by viewModel.albumsState.collectAsState()
    val songsByAlbumState by viewModel.songsByAlbumState.collectAsState()

    LaunchedEffect(Unit) {
        // viewModel.loadAllSongs()
        viewModel.loadStoredSongs()
        viewModel.loadAllAlbums()
        viewModel.loadSongsByAlbumId("3T4tUhGYeRNVUGevb0wThu")
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
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text("Total Songs: ${songsState?.size}")
                Text("Total Albums: ${albumsState?.size}")
                Text("Total Songs for Album ID: ${songsByAlbumState?.size}")
            }
        }
    }
}

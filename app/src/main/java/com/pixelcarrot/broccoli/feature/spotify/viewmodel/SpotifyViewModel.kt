package com.pixelcarrot.broccoli.feature.spotify.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pixelcarrot.broccoli.domain.usecase.GetAllAlbumsUseCase
import com.pixelcarrot.broccoli.domain.usecase.GetAllSongsUseCase
import com.pixelcarrot.broccoli.domain.usecase.GetAllStoredSongsUseCase
import com.pixelcarrot.broccoli.domain.usecase.GetSongsByAlbumIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SpotifyViewModel @Inject constructor(
    private val getAllSongsUseCase: GetAllSongsUseCase,
    private val getAllAlbumsUseCase: GetAllAlbumsUseCase,
    private val getAllStoredSongsUseCase: GetAllStoredSongsUseCase,
    private val getSongsByAlbumIdUseCase: GetSongsByAlbumIdUseCase,
) : ViewModel() {

    private val _steps = MutableStateFlow<List<String>>(emptyList())
    val steps: StateFlow<List<String>> get() = _steps

    private fun proceedToNextStep(stepDescription: String) {
        _steps.value = _steps.value.toList() + stepDescription
    }

    fun fetchAllSongs() {
        viewModelScope.launch {
            val startTime = System.currentTimeMillis()
            val songs = getAllSongsUseCase()
            val endTime = System.currentTimeMillis()
            proceedToNextStep("Step 1: Fetched ${songs.size} songs from API in ${endTime - startTime} ms")
        }
    }

    fun fetchAllStoredSongs() {
        viewModelScope.launch {
            val startTime = System.currentTimeMillis()
            val songs = getAllStoredSongsUseCase()
            val endTime = System.currentTimeMillis()
            proceedToNextStep("Step 2: Fetched ${songs.size} stored songs in ${endTime - startTime} ms")
        }
    }

    fun fetchAllStoredAlbums() {
        viewModelScope.launch {
            val startTime = System.currentTimeMillis()
            val albums = getAllAlbumsUseCase()
            val endTime = System.currentTimeMillis()
            proceedToNextStep("Step 3: Fetched ${albums.size} stored albums in ${endTime - startTime} ms")
        }
    }

    fun fetchSongsByAlbumId(albumId: String) {
        viewModelScope.launch {
            val startTime = System.currentTimeMillis()
            val songs = getSongsByAlbumIdUseCase(albumId)
            val endTime = System.currentTimeMillis()
            proceedToNextStep("Step 4: Fetched ${songs.size} songs for album ID '$albumId' in ${endTime - startTime} ms")
        }
    }

}

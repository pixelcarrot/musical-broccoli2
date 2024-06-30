package com.pixelcarrot.broccoli.feature.spotify.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pixelcarrot.broccoli.domain.model.Album
import com.pixelcarrot.broccoli.domain.model.Song
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

    private val _songsState = MutableStateFlow<List<Song>>(emptyList())
    val songsState: StateFlow<List<Song>?> get() = _songsState

    private val _albumsState = MutableStateFlow<List<Album>>(emptyList())
    val albumsState: StateFlow<List<Album>?> get() = _albumsState

    private val _songsByAlbumState = MutableStateFlow<List<Song>>(emptyList())
    val songsByAlbumState: StateFlow<List<Song>?> get() = _songsByAlbumState


    fun loadAllSongs() {
        viewModelScope.launch {
            val songs = getAllSongsUseCase()
            _songsState.value = songs
        }
    }

    fun loadAllAlbums() {
        viewModelScope.launch {
            val albums = getAllAlbumsUseCase()
            _albumsState.value = albums
        }
    }

    fun loadStoredSongs() {
        viewModelScope.launch {
            val songs = getAllStoredSongsUseCase()
            _songsState.value = songs
        }
    }

    fun loadSongsByAlbumId(albumId: String) {
        viewModelScope.launch {
            val songs = getSongsByAlbumIdUseCase(albumId)
            _songsByAlbumState.value = songs
        }
    }

}

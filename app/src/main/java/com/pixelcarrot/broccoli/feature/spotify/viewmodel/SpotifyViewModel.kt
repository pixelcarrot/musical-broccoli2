package com.pixelcarrot.broccoli.feature.spotify.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pixelcarrot.broccoli.domain.model.Song
import com.pixelcarrot.broccoli.domain.usecase.GetAllSongsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SpotifyViewModel @Inject constructor(
    private val getAllSongsUseCase: GetAllSongsUseCase,
) : ViewModel() {

    private val _songsState = MutableStateFlow<List<Song>>(emptyList())
    val songsState: StateFlow<List<Song>?> get() = _songsState

    fun loadAllSongs() {
        viewModelScope.launch {
            runCatching {
                getAllSongsUseCase()
            }.onSuccess {
                _songsState.value = it
            }.onFailure {
                _songsState.value = emptyList()
            }
        }
    }
}

package com.pixelcarrot.broccoli.domain.usecase

import com.pixelcarrot.broccoli.data.repository.SpotifyRepository
import com.pixelcarrot.broccoli.domain.model.Song
import javax.inject.Inject

class GetSongsByAlbumIdUseCase @Inject constructor(
    private val repository: SpotifyRepository
) {
    suspend operator fun invoke(albumId: String): List<Song> {
        return repository.getSongsByAlbumId(albumId)
    }
}

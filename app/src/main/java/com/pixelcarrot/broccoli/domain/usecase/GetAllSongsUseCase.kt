package com.pixelcarrot.broccoli.domain.usecase

import com.pixelcarrot.broccoli.data.repository.SpotifyRepository
import com.pixelcarrot.broccoli.domain.model.Song
import javax.inject.Inject

class GetAllSongsUseCase @Inject constructor(
    private val repository: SpotifyRepository
) {
    suspend operator fun invoke(): List<Song> {
        return repository.fetchAndStoreAllSongs()
    }
}

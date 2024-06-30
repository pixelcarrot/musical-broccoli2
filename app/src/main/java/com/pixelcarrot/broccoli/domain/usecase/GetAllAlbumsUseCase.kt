package com.pixelcarrot.broccoli.domain.usecase

import com.pixelcarrot.broccoli.data.repository.SpotifyRepository
import com.pixelcarrot.broccoli.domain.model.Album
import javax.inject.Inject

class GetAllAlbumsUseCase @Inject constructor(
    private val repository: SpotifyRepository
) {
    suspend operator fun invoke(): List<Album> {
        return repository.getAllAlbums()
    }
}

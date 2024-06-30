package com.pixelcarrot.broccoli.data.mapper

import com.pixelcarrot.broccoli.data.local.entity.AlbumEntity
import com.pixelcarrot.broccoli.data.remote.response.SongResponse
import com.pixelcarrot.broccoli.domain.model.Album

object AlbumMapper {
    fun fromResponseToEntity(songResponse: SongResponse): AlbumEntity {
        return AlbumEntity(
            albumId = songResponse.trackAlbumId,
            albumName = songResponse.trackAlbumName.orEmpty(),
            albumReleaseDate = songResponse.trackAlbumReleaseDate
        )
    }

    fun fromEntityToModel(albumEntity: AlbumEntity): Album {
        return Album(
            albumId = albumEntity.albumId,
            albumName = albumEntity.albumName,
            albumReleaseDate = albumEntity.albumReleaseDate
        )
    }
}

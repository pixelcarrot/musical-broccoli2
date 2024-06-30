package com.pixelcarrot.broccoli.data.mapper

import com.pixelcarrot.broccoli.data.local.entity.SongEntity
import com.pixelcarrot.broccoli.data.remote.response.SongResponse
import com.pixelcarrot.broccoli.domain.model.Song

object SongMapper {
    fun fromResponseToEntity(songResponse: SongResponse): SongEntity {
        return SongEntity(
            trackId = songResponse.trackId,
            trackName = songResponse.trackName.orEmpty(),
            trackArtist = songResponse.trackArtist.orEmpty(),
            trackPopularity = songResponse.trackPopularity,
            trackAlbumId = songResponse.trackAlbumId,
            trackAlbumName = songResponse.trackAlbumName.orEmpty(),
            trackAlbumReleaseDate = songResponse.trackAlbumReleaseDate,
            playlistName = songResponse.playlistName,
            playlistId = songResponse.playlistId,
            playlistGenre = songResponse.playlistGenre,
            playlistSubgenre = songResponse.playlistSubgenre,
            danceability = songResponse.danceability,
            energy = songResponse.energy,
            key = songResponse.key,
            loudness = songResponse.loudness,
            mode = songResponse.mode,
            speechiness = songResponse.speechiness,
            acousticness = songResponse.acousticness,
            instrumentalness = songResponse.instrumentalness,
            liveness = songResponse.liveness,
            valence = songResponse.valence,
            tempo = songResponse.tempo,
            durationMs = songResponse.durationMs
        )
    }

    fun fromEntityToModel(songEntity: SongEntity): Song {
        return Song(
            trackId = songEntity.trackId,
            trackName = songEntity.trackName,
            trackArtist = songEntity.trackArtist,
            trackPopularity = songEntity.trackPopularity,
            trackAlbumId = songEntity.trackAlbumId,
            trackAlbumName = songEntity.trackAlbumName,
            trackAlbumReleaseDate = songEntity.trackAlbumReleaseDate,
            playlistName = songEntity.playlistName,
            playlistId = songEntity.playlistId,
            playlistGenre = songEntity.playlistGenre,
            playlistSubgenre = songEntity.playlistSubgenre,
            danceability = songEntity.danceability,
            energy = songEntity.energy,
            key = songEntity.key,
            loudness = songEntity.loudness,
            mode = songEntity.mode,
            speechiness = songEntity.speechiness,
            acousticness = songEntity.acousticness,
            instrumentalness = songEntity.instrumentalness,
            liveness = songEntity.liveness,
            valence = songEntity.valence,
            tempo = songEntity.tempo,
            durationMs = songEntity.durationMs
        )
    }
}

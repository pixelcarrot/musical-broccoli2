package com.pixelcarrot.broccoli.domain.model

data class Song(
    val trackId: String,
    val trackName: String,
    val trackArtist: String,
    val trackPopularity: Int,
    val trackAlbumId: String,
    val trackAlbumName: String,
    val trackAlbumReleaseDate: String,
    val playlistName: String,
    val playlistId: String,
    val playlistGenre: String,
    val playlistSubgenre: String,
    val danceability: Float,
    val energy: Float,
    val key: Int,
    val loudness: Float,
    val mode: Int,
    val speechiness: Float,
    val acousticness: Float,
    val instrumentalness: Float,
    val liveness: Float,
    val valence: Float,
    val tempo: Float,
    val durationMs: Int
)

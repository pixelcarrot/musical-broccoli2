package com.pixelcarrot.broccoli.data.remote.response

import com.google.gson.annotations.SerializedName

data class SongResponse(
    @SerializedName("track_id") val trackId: String,
    @SerializedName("track_name") val trackName: String?,
    @SerializedName("track_artist") val trackArtist: String?,
    @SerializedName("track_popularity") val trackPopularity: Int,
    @SerializedName("track_album_id") val trackAlbumId: String,
    @SerializedName("track_album_name") val trackAlbumName: String?,
    @SerializedName("track_album_release_date") val trackAlbumReleaseDate: String,
    @SerializedName("playlist_name") val playlistName: String,
    @SerializedName("playlist_id") val playlistId: String,
    @SerializedName("playlist_genre") val playlistGenre: String,
    @SerializedName("playlist_subgenre") val playlistSubgenre: String,
    @SerializedName("danceability") val danceability: Float,
    @SerializedName("energy") val energy: Float,
    @SerializedName("key") val key: Int,
    @SerializedName("loudness") val loudness: Float,
    @SerializedName("mode") val mode: Int,
    @SerializedName("speechiness") val speechiness: Float,
    @SerializedName("acousticness") val acousticness: Float,
    @SerializedName("instrumentalness") val instrumentalness: Float,
    @SerializedName("liveness") val liveness: Float,
    @SerializedName("valence") val valence: Float,
    @SerializedName("tempo") val tempo: Float,
    @SerializedName("duration_ms") val durationMs: Int
)

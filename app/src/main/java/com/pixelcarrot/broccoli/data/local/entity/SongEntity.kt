package com.pixelcarrot.broccoli.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "songs",
    foreignKeys = [
        ForeignKey(
            entity = AlbumEntity::class,
            parentColumns = ["album_id"],
            childColumns = ["track_album_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class SongEntity(
    @PrimaryKey @ColumnInfo(name = "track_id") val trackId: String,
    @ColumnInfo(name = "track_name") val trackName: String,
    @ColumnInfo(name = "track_artist") val trackArtist: String,
    @ColumnInfo(name = "track_popularity") val trackPopularity: Int,
    @ColumnInfo(name = "track_album_id") val trackAlbumId: String,
    @ColumnInfo(name = "track_album_name") val trackAlbumName: String,
    @ColumnInfo(name = "track_album_release_date") val trackAlbumReleaseDate: String,
    @ColumnInfo(name = "playlist_name") val playlistName: String,
    @ColumnInfo(name = "playlist_id") val playlistId: String,
    @ColumnInfo(name = "playlist_genre") val playlistGenre: String,
    @ColumnInfo(name = "playlist_subgenre") val playlistSubgenre: String,
    @ColumnInfo(name = "danceability") val danceability: Float,
    @ColumnInfo(name = "energy") val energy: Float,
    @ColumnInfo(name = "key") val key: Int,
    @ColumnInfo(name = "loudness") val loudness: Float,
    @ColumnInfo(name = "mode") val mode: Int,
    @ColumnInfo(name = "speechiness") val speechiness: Float,
    @ColumnInfo(name = "acousticness") val acousticness: Float,
    @ColumnInfo(name = "instrumentalness") val instrumentalness: Float,
    @ColumnInfo(name = "liveness") val liveness: Float,
    @ColumnInfo(name = "valence") val valence: Float,
    @ColumnInfo(name = "tempo") val tempo: Float,
    @ColumnInfo(name = "duration_ms") val durationMs: Int
)

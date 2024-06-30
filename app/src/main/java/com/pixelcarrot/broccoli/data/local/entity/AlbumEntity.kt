package com.pixelcarrot.broccoli.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "albums")
data class AlbumEntity(
    @PrimaryKey @ColumnInfo(name = "album_id") val albumId: String,
    @ColumnInfo(name = "album_name") val albumName: String,
    @ColumnInfo(name = "album_release_date") val albumReleaseDate: String
)

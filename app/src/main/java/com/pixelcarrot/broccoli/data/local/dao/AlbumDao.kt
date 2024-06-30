package com.pixelcarrot.broccoli.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pixelcarrot.broccoli.data.local.entity.AlbumEntity

@Dao
interface AlbumDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(albums: List<AlbumEntity>)

    @Query("SELECT * FROM albums")
    suspend fun getAllAlbums(): List<AlbumEntity>
}

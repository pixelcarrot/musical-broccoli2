package com.pixelcarrot.broccoli.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pixelcarrot.broccoli.data.local.dao.AlbumDao
import com.pixelcarrot.broccoli.data.local.dao.SongDao
import com.pixelcarrot.broccoli.data.local.entity.AlbumEntity
import com.pixelcarrot.broccoli.data.local.entity.SongEntity

@Database(
    entities = [
        SongEntity::class,
        AlbumEntity::class,
    ],
    version = 1,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun songDao(): SongDao
    abstract fun albumDao(): AlbumDao
}

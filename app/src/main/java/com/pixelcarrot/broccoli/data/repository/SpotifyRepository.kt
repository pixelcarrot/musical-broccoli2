package com.pixelcarrot.broccoli.data.repository

import com.pixelcarrot.broccoli.data.local.dao.AlbumDao
import com.pixelcarrot.broccoli.data.local.dao.SongDao
import com.pixelcarrot.broccoli.data.local.entity.AlbumEntity
import com.pixelcarrot.broccoli.data.mapper.AlbumMapper
import com.pixelcarrot.broccoli.data.mapper.SongMapper
import com.pixelcarrot.broccoli.data.remote.api.SpotifyApi
import com.pixelcarrot.broccoli.data.remote.response.SongResponse
import com.pixelcarrot.broccoli.domain.model.Song
import javax.inject.Inject

class SpotifyRepository @Inject constructor(
    private val api: SpotifyApi,
    private val albumDao: AlbumDao,
    private val songDao: SongDao,
) {
    suspend fun fetchAndStoreAllSongs(pageSize: Int = 500): List<Song> {
        val allSongs = mutableListOf<SongResponse>()
        val allAlbums = mutableSetOf<AlbumEntity>()
        var page = 1
        var totalPages: Int
        do {
            val response = api.getSongs(page, pageSize)
            totalPages = response.totalPages
            allSongs.addAll(response.data)
            response.data.forEach { songResponse ->
                allAlbums.add(AlbumMapper.fromResponseToEntity(songResponse))
            }
            page++
        } while (page <= totalPages)

        // Convert SongResponse to SongEntity
        val songEntities = allSongs.map { SongMapper.fromResponseToEntity(it) }

        // Insert albums and songs into database
        albumDao.insertAll(allAlbums.toList())
        songDao.insertAll(songEntities)

        return songEntities.map { SongMapper.fromEntityToModel(it) }
    }
}

package com.pixelcarrot.broccoli.data.remote.api

import com.pixelcarrot.broccoli.data.remote.response.SongListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SpotifyApi {

    @GET("songs")
    suspend fun getSongs(
        @Query("page") page: Int,
        @Query("page_size") pageSize: Int
    ): SongListResponse

}

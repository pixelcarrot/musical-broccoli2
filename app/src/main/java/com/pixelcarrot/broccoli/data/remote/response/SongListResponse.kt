package com.pixelcarrot.broccoli.data.remote.response

import com.google.gson.annotations.SerializedName

data class SongListResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("page_size") val pageSize: Int,
    @SerializedName("total") val total: Int,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("data") val data: List<SongResponse>
)

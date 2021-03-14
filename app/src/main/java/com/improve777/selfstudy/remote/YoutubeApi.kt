package com.improve777.selfstudy.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeApi {

    @GET("search")
    suspend fun getVideoList(
        @Query("key") key: String,
        @Query("part") part: String,
        @Query("q") q: String?,
    ): VideoListResponse
}
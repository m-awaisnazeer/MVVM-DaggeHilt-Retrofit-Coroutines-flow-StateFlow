package com.communisolve.mvvmdaggerhiltretrofitcoroutinesstateflow.network

import com.communisolve.mvvmdaggerhiltretrofitcoroutinesstateflow.data.local.Post
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getPosts(): List<Post>
}
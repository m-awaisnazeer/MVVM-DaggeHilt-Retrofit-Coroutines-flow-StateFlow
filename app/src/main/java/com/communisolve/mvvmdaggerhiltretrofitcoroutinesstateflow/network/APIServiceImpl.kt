package com.communisolve.mvvmdaggerhiltretrofitcoroutinesstateflow.network

import com.communisolve.mvvmdaggerhiltretrofitcoroutinesstateflow.data.local.Post
import javax.inject.Inject

class APIServiceImpl @Inject constructor(private val apiService: ApiService) {
    suspend fun getPost(): List<Post> = apiService.getPosts()
}
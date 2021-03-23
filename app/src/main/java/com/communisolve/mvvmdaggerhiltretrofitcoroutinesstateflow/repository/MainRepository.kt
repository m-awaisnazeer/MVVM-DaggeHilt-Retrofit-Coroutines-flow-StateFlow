package com.communisolve.mvvmdaggerhiltretrofitcoroutinesstateflow.repository

import com.communisolve.mvvmdaggerhiltretrofitcoroutinesstateflow.data.local.Post
import com.communisolve.mvvmdaggerhiltretrofitcoroutinesstateflow.network.APIServiceImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiServiceImpl: APIServiceImpl) {

    fun getPosts() : Flow<List<Post>> = flow {
        emit(apiServiceImpl.getPost())
    }.flowOn(Dispatchers.IO)
}
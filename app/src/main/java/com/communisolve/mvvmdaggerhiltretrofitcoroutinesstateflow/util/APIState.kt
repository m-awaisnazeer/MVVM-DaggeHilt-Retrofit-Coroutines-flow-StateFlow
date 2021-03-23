package com.communisolve.mvvmdaggerhiltretrofitcoroutinesstateflow.util

import com.communisolve.mvvmdaggerhiltretrofitcoroutinesstateflow.data.local.Post

sealed class APIState {

    object Empty : APIState()
    object Loading : APIState()
    class Error(val msg: Throwable) : APIState()
    class Success(val data: List<Post>) : APIState()
}

package com.communisolve.mvvmdaggerhiltretrofitcoroutinesstateflow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.communisolve.mvvmdaggerhiltretrofitcoroutinesstateflow.repository.MainRepository
import com.communisolve.mvvmdaggerhiltretrofitcoroutinesstateflow.util.APIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(val mainRepository: MainRepository) : ViewModel() {
    private val postStateFlow: MutableStateFlow<APIState> = MutableStateFlow(APIState.Empty)

    val _postStateFlow: StateFlow<APIState> = postStateFlow

    fun getPosts() = viewModelScope.launch {
        postStateFlow.value = APIState.Loading
        mainRepository.getPosts()
            .catch { e ->
                postStateFlow.value = APIState.Error(e)
            }.collect { data ->
                postStateFlow.value = APIState.Success(data)

            }
    }

}
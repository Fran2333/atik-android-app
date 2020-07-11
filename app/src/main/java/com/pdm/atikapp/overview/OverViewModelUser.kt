package com.pdm.atikapp.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pdm.atikapp.network.AtikApi
import com.pdm.atikapp.network.LocationProperty
import com.pdm.atikapp.network.UserProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class OverViewModelUser : ViewModel() {
    private val _respone = MutableLiveData<List<UserProperty>>()

    val response : LiveData<List<UserProperty>>
        get() = _respone

    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(
        viewModelJob + Dispatchers.Main
    )

    init {
        getUserProperties()
    }

    private fun getUserProperties(){
        coroutineScope.launch {
            var getUserPropertyDeferred = AtikApi.retrofitService.getUserProperties()
            try {
                var listResult = getUserPropertyDeferred.await()
                _respone.value = listResult
            }catch (e : Exception){
                e.message
            }
        }
    }
}
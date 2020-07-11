package com.pdm.atikapp.overview

import android.location.LocationProvider
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pdm.atikapp.network.AtikApi
import com.pdm.atikapp.network.LocationProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class OverViewModelLocation : ViewModel(){

    private val _respone = MutableLiveData<List<LocationProperty>>()

    val response : LiveData<List<LocationProperty>>
        get() = _respone

    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(
        viewModelJob + Dispatchers.Main
    )

    init {
    getLocationProperties()
    }

    private fun getLocationProperties(){
        coroutineScope.launch {
            var getLocationPropertyDeferred = AtikApi.retrofitService.getLocationProperties()
            try {
                var listResult = getLocationPropertyDeferred.await()
                _respone.value = listResult
            }catch (e : Exception){
                e.message
            }
        }
    }
}
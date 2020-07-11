package com.pdm.atikapp.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pdm.atikapp.network.AtikApi
import com.pdm.atikapp.network.LocationProperty
import com.pdm.atikapp.network.RolProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class OverViewModelRole {
    private val _respone = MutableLiveData<List<RolProperty>>()

    val response : LiveData<List<RolProperty>>
        get() = _respone

    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(
        viewModelJob + Dispatchers.Main
    )

    init {
        getRoleProperties()
    }

    private fun getRoleProperties(){
        coroutineScope.launch {
            var getRolPropertyDeferred = AtikApi.retrofitService.getRoleProperties()
            try {
                var listResult = getRolPropertyDeferred.await()
                _respone.value = listResult
            }catch (e : Exception){
                e.message
            }
        }
    }
}
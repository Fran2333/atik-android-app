package com.pdm.atikapp.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pdm.atikapp.network.AtikApi
import com.pdm.atikapp.network.LocationProperty
import com.pdm.atikapp.network.ProductProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class OverViewModelProduct {
    private val _respone = MutableLiveData<List<ProductProperty>>()

    val response : LiveData<List<ProductProperty>>
        get() = _respone

    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(
        viewModelJob + Dispatchers.Main
    )

    init {
        getProductProperties()
    }

    private fun getProductProperties(){
        coroutineScope.launch {
            var getProductPropertyDeferred = AtikApi.retrofitService.getProductProperties()
            try {
                var listResult = getProductPropertyDeferred.await()
                _respone.value = listResult
            }catch (e : Exception){
                e.message
            }
        }
    }
}
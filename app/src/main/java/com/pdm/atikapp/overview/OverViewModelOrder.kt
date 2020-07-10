package com.pdm.atikapp.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pdm.atikapp.network.AtikApi
import com.pdm.atikapp.network.LocationProperty
import com.pdm.atikapp.network.OrderProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class OverViewModelOrder: ViewModel() {
    private val _respone = MutableLiveData<List<OrderProperty>>()

    val response : LiveData<List<OrderProperty>>
        get() = _respone

    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(
        viewModelJob + Dispatchers.Main
    )

    init {
        getOrderProperties()
    }

    private fun getOrderProperties(){
        coroutineScope.launch {
            var getOrderPropertyDeferred = AtikApi.retrofitService.getOrderProperties()
            try {
                var listResult = getOrderPropertyDeferred.await()
                _respone.value = listResult
            }catch (e : Exception){
                e.message
            }
        }
    }
}
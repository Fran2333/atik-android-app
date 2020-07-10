package com.pdm.atikapp.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pdm.atikapp.network.AtikApi
import com.pdm.atikapp.network.Category
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.collections.ArrayList

enum class AtikApiStatus {
    LOADING, ERROR, DONE
}


class CategoryViewModel : ViewModel() {

    private val _status = MutableLiveData<AtikApiStatus>()

    private val _category = MutableLiveData<List<Category>>()

    private val _navigateToSelectedCategory = MutableLiveData<Category>()

    val status: LiveData<AtikApiStatus>
        get() = _status

    val category: LiveData<List<Category>>
        get() = _category

    val navigateToSelectedCategory: LiveData<Category>
        get() = _navigateToSelectedCategory



    private val viewModelJob = Job()

    private val coroutineScope = CoroutineScope(
        viewModelJob + Dispatchers.Main
    )

    init {
        getAtikCategories()
    }

    private fun getAtikCategories() {
        coroutineScope.launch {
            val getPropertiesDeferred = AtikApi.retrofitService.getCategoriesAsync()
            try {
                _status.value = AtikApiStatus.LOADING
                val listResult = getPropertiesDeferred.await()
                _status.value = AtikApiStatus.DONE
                _category.value = listResult
                Log.d("LISTA", listResult.toString())
            } catch (e: Exception) {
                _status.value = AtikApiStatus.ERROR
                _category.value = ArrayList()
                Log.d("ERROR", e.message)
            }
        }
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
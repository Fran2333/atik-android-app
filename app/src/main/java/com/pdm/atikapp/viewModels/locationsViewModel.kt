package com.pdm.atikapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.pdm.atikapp.Repository.RepositoryNetwork
import com.pdm.atikapp.entity.locations

class locationsViewModel : ViewModel(){

    val repository = RepositoryNetwork()

    val listLocations : LiveData<List<locations>> = repository.locations
    val getLocations : LiveData<Boolean> = repository.getLocations

    fun getLocations(){
        repository.getLocationsList()
    }
}
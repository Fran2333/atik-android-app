package com.pdm.atikapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.pdm.atikapp.Repository.RepositoryNetwork
import com.pdm.atikapp.entity.ActiveOrder

class ActiveOrderViewModel : ViewModel() {

    val repository = RepositoryNetwork()

    val activeList : LiveData<List<ActiveOrder>>  = repository.active
    val getActive : LiveData<Boolean> = repository.ObtuveLasActivas

    fun getOrders(){
        repository.getActivesList()
    }
}
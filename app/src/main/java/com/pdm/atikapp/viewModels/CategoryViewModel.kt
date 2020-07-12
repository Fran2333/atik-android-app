package com.pdm.atikapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.pdm.atikapp.Repository.RepositoryNetwork
import com.pdm.atikapp.entity.categories
import com.pdm.atikapp.entity.product

class CategoryViewModel : ViewModel() {
    val repository = RepositoryNetwork()

    val productsList: LiveData<List<product>> = repository.products
    val getProducts: LiveData<Boolean> = repository.getProducts


    fun getProducts(){
        repository.getProductsList()
    }
}
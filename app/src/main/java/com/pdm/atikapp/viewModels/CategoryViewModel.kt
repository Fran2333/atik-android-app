package com.pdm.atikapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.pdm.atikapp.Repository.RepositoryNetwork
import com.pdm.atikapp.entity.Product

class CategoryViewModel : ViewModel() {
    val repository = RepositoryNetwork()

    val productsList: LiveData<List<Product>> = repository.products
    val getProducts: LiveData<Boolean> = repository.getProducts


    fun getProductsByCategory(){
        repository.getProductsList()
    }
}
package com.pdm.atikapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.pdm.atikapp.Repository.RepositoryNetwork
import com.pdm.atikapp.entity.Categories

class ProductViewModel: ViewModel() {

    val Repository = RepositoryNetwork()

    val listaCategorias: LiveData<List<Categories>> = Repository.categorias
    val ObtuveCategorias: LiveData<Boolean> = Repository.ObtuveLasCategorias


    fun getCategorias(){
        Repository.getCategoriesList()
    }

}
package com.pdm.atikapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.pdm.atikapp.Repository.RepositoryNetwork
import com.pdm.atikapp.entity.categories

class ProductosViewModel: ViewModel() {

    val Repository = RepositoryNetwork()

    val ListaCategorias: LiveData<List<categories>> = Repository.categorias
    val ObtuveCategorias: LiveData<Boolean> = Repository.ObtuveLasCategorias


    fun getCategorias(){
        Repository.getCategoriesList()
    }




}
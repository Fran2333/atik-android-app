package com.pdm.atikapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.pdm.atikapp.Repository.RepositoryNetwork
import com.pdm.atikapp.entity.Promotions

class PromotionsViewModel : ViewModel() {

    val repository = RepositoryNetwork()

    val listPromotions: LiveData<List<Promotions>> = repository.Promotions
    val getPromotions: LiveData<Boolean> = repository.getPromotions

    fun getPromotions() {
        repository.getPromotionsList()
    }

}
package com.pdm.atikapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.pdm.atikapp.Repository.RepositoryNetwork
import com.pdm.atikapp.entity.promotions

class PromotionsViewModel : ViewModel() {

    val repository = RepositoryNetwork()

    val listPromotions: LiveData<List<promotions>> = repository.promotions
    val getPromotions: LiveData<Boolean> = repository.getPromotions

    fun getPromotions() {
        repository.getPromotionsList()
    }

}
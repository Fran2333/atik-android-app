package com.pdm.atikapp.overview

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.pdm.atikapp.R
import com.pdm.atikapp.network.LocationProperty
import com.pdm.atikapp.network.PromotionProperty

class DetailViewModelPromotion(promotionProperty: PromotionProperty, app : Application) : AndroidViewModel(app) {
    private val _selectedProperty = MutableLiveData<PromotionProperty>()
    val selectedProperty : LiveData<PromotionProperty>
        get() = _selectedProperty

    val displayPropertyName = Transformations.map(selectedProperty){
        app.applicationContext.getString(
            R.string.display_promotion_name
        , it.name
        )
    }

    val displayPropertyDescription = Transformations.map(selectedProperty){
        app.applicationContext.getString(
            R.string.display_promotion_discount
        , it.discount
        )
    }
    init {
        _selectedProperty.value = promotionProperty
    }
}
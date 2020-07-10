package com.pdm.atikapp.overview

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.pdm.atikapp.R
import com.pdm.atikapp.network.LocationProperty
import kotlinx.android.synthetic.main.list_element.view.*

class DetailViewModelLocation(locationProperty: LocationProperty, app : Application) : AndroidViewModel(app) {

    private val _selectedProperty = MutableLiveData<LocationProperty>()
    val selectedProperty : LiveData<LocationProperty>
                get() = _selectedProperty

    val displayPropertyName = Transformations.map(selectedProperty){
        app.applicationContext.getString(
            R.string.display_name_location
            ,it.name)
    }

    val displayPropertyDescription = Transformations.map(selectedProperty){
        app.applicationContext.getString(
            R.string.display_name_location
        ,it.address
        )
    }
    init {
        _selectedProperty.value = locationProperty
    }
}
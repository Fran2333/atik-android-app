package com.pdm.atikapp.overview

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.pdm.atikapp.R
import com.pdm.atikapp.network.UserProperty

class DetailViewModelUser(userProperty: UserProperty, app : Application): AndroidViewModel(app) {

    private val _selectedProperty = MutableLiveData<UserProperty>()

    val selectedProperty : LiveData<UserProperty>
        get() = _selectedProperty

    val displayUserName=Transformations.map(selectedProperty){
        app.applicationContext.getString(
            R.string.display_name_user
        ,   it.name
        )
    }
    val displayUserLastname=Transformations.map(selectedProperty){
        app.applicationContext.getString(
            R.string.display_lastname_user
        ,   it.lastname
        )
    }

    val displayUserPhoneNumber=Transformations.map(selectedProperty){
        app.applicationContext.getString(
            R.string.display_phoneNumber_user
            ,   it.phoneNumber
        )
    }

    val displayUserEmail=Transformations.map(selectedProperty){
        app.applicationContext.getString(
            R.string.display_email_user
            ,   it.email
        )
    }



}
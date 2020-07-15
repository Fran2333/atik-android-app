package com.pdm.atikapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.pdm.atikapp.Repository.RepositoryNetwork
import com.pdm.atikapp.entity.Register
import com.pdm.atikapp.entity.User
import org.json.JSONObject

class UserViewModel : ViewModel() {

    val Repository = RepositoryNetwork()
    val Registrado : LiveData<Boolean> = Repository.registrado
    fun Registrar(user : User){
        Repository.Register(user)
    }
}
package com.pdm.atikapp.viewModels

import androidx.lifecycle.LiveData
import com.pdm.atikapp.Repository.RepositoryNetwork
import com.pdm.atikapp.entity.User

class loginViewModel {

    val Repository = RepositoryNetwork()

    val pass: LiveData<Boolean> = Repository.pass
    val usuario: LiveData<User> = Repository.usuario
}
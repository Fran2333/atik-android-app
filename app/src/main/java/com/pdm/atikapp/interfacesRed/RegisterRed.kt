package com.pdm.atikapp.interfacesRed

import com.pdm.atikapp.entity.RegisterResponse
import com.pdm.atikapp.entity.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterRed {

    @POST("users/create")
    fun createUser(@Body user : User) : Call<RegisterResponse>

}
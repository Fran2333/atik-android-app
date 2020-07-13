package com.pdm.atikapp.interfacesRed

import com.pdm.atikapp.entity.login
import com.pdm.atikapp.entity.loginResponse
import com.pdm.atikapp.entity.userResponse
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Body
import retrofit2.http.GET

interface loginRed {

    @POST("login")
    fun getLoginResponse(@Body login : login) : Call<userResponse>

}
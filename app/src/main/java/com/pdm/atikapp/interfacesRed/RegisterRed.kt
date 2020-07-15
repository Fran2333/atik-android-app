package com.pdm.atikapp.interfacesRed

import com.pdm.atikapp.entity.RegisterResponse
import com.pdm.atikapp.entity.User
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface RegisterRed {

    @POST("users/create")
    @Headers(
        "Content-Type: application/json"
    )
    fun createUser(@Body user: User): Call<ResponseBody>

}
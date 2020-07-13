package com.pdm.atikapp.interfacesRed

import com.pdm.atikapp.entity.promotionsResponse
import retrofit2.Call
import retrofit2.http.GET

interface promotionsRed {

    @GET("promotions")
    fun getPromotions() : Call<promotionsResponse>
}
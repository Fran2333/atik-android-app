package com.pdm.atikapp.interfacesRed

import com.pdm.atikapp.entity.PromotionsResponse
import retrofit2.Call
import retrofit2.http.GET

interface PromotionsRed {

    @GET("promotions")
    fun getPromotions() : Call<PromotionsResponse>
}
package com.pdm.atikapp.interfacesRed

import com.pdm.atikapp.entity.productResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface productsRed {

    @GET("products")
    fun getProductsByCategory() : Call<productResponse>

}
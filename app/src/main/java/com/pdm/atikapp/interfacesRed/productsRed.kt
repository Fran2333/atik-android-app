package com.pdm.atikapp.interfacesRed

import com.pdm.atikapp.entity.productResponse
import retrofit2.Call
import retrofit2.http.GET

interface productsRed {

    @GET("products")
    fun getProducts() : Call<productResponse>

}
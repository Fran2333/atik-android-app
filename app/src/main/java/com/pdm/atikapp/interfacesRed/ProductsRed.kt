package com.pdm.atikapp.interfacesRed

import com.pdm.atikapp.entity.ProductResponse
import retrofit2.Call
import retrofit2.http.GET

interface ProductsRed {

    @GET("products")
    fun getProductsByCategory() : Call<ProductResponse>

}
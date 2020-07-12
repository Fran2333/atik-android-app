package com.pdm.atikapp.interfacesRed

import retrofit2.Call
import com.pdm.atikapp.entity.categories
import com.pdm.atikapp.entity.productResponse

import retrofit2.http.GET

interface categoriasRed {

    @GET("categories")
    fun getCategories() : Call<List<categories>>

}
package com.pdm.atikapp.interfacesRed

import com.pdm.atikapp.entity.categoriasResponse
import retrofit2.Call
import com.pdm.atikapp.entity.categories
import retrofit2.http.Body

import retrofit2.http.GET

interface categoriasRed {

    @GET("categories")
    fun getCategories() : Call<List<categories>>


}
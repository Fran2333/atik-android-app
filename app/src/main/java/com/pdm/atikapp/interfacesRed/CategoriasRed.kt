package com.pdm.atikapp.interfacesRed

import retrofit2.Call
import com.pdm.atikapp.entity.Categories

import retrofit2.http.GET

interface CategoriasRed {

    @GET("categories")
    fun getCategories() : Call<List<Categories>>

}
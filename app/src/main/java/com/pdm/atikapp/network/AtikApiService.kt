package com.pdm.atikapp.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


private const val BASE_URL = " https://atik-api.herokuapp.com/"


private val moshi = Moshi
    .Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface AtikApiService {

    @GET("/api/categories")
    fun getCategoriesAsync(): Deferred<List<Category>>

}

object AtikApi {
    val retrofitService: AtikApiService by lazy {
        retrofit.create(AtikApiService::class.java)
    }
}
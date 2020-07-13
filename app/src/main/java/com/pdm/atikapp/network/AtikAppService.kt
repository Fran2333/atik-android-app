package com.pdm.atikapp.network

import androidx.room.FtsOptions
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://atik-api.herokuapp.com/"
private val moshi = Moshi
    .Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private val retrofit = Retrofit
    .Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface AtikAppService {

     @GET("api/locations")
     fun getLocationProperties() : Deferred<List<LocationProperty>>

    @GET("api/order")
    fun getOrderProperties() : Deferred<List<OrderProperty>>

    @GET("api/promotion")
    fun getPromotionProperties() : Deferred<List<PromotionProperty>>

    @GET("api/user")
    fun getUserProperties() : Deferred<List<UserProperty>>

    @GET("api/product")
    fun getProductProperties () : Deferred<List<ProductProperty>>

    @GET("api/role")
    fun getRoleProperties() : Deferred<List<RolProperty>>

}

object AtikApi{
    val retrofitService : AtikAppService by lazy {
        retrofit.create(AtikAppService::class.java)
    }
}
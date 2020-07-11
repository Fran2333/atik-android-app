package com.pdm.atikapp.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object AtikAppService2 {
    const val URL: String = "https://atik-api.herokuapp.com/api/"



    lateinit var client: OkHttpClient
    fun init(){
        client = OkHttpClient.Builder()
            .retryOnConnectionFailure(true).build()

        retrofit = Retrofit.Builder()

            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(URL)
            .client(client).build()

    }





    private lateinit var retrofit: Retrofit


    fun<T> buildService(Service: Class<T>): T {
        return retrofit.create(Service)
    }
}
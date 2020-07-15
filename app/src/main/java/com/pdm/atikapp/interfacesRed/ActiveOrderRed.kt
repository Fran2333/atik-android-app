package com.pdm.atikapp.interfacesRed

import com.pdm.atikapp.entity.ActiveOrder
import com.pdm.atikapp.entity.ActiveOrderResponse
import retrofit2.Call
import retrofit2.http.GET

interface ActiveOrderRed {

    @GET("orders")
    fun getActiveOrders() : Call<ActiveOrderResponse>
}
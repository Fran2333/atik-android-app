package com.pdm.atikapp.interfacesRed

import com.pdm.atikapp.entity.locationResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface locationsRed {

    @GET("locations")
    fun getLocations() : Call<locationResponse>


}
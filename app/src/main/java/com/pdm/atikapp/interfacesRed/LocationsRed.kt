package com.pdm.atikapp.interfacesRed

import com.pdm.atikapp.entity.LocationResponse
import retrofit2.Call
import retrofit2.http.GET

interface LocationsRed {

    @GET("locations")
    fun getLocations() : Call<LocationResponse>


}
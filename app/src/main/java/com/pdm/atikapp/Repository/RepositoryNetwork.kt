package com.pdm.atikapp.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.pdm.atikapp.interfacesRed.ProductsRed

import com.pdm.atikapp.entity.*
import com.pdm.atikapp.interfacesRed.CategoriasRed
import com.pdm.atikapp.interfacesRed.LocationsRed
import com.pdm.atikapp.interfacesRed.PromotionsRed

import com.pdm.atikapp.network.AtikAppService2
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryNetwork {

    //Categorias
    private val _categorias = MutableLiveData<List<Categories>>()
    val categorias: LiveData<List<Categories>> get() = _categorias

    val _ObtuveCategories = MutableLiveData<Boolean>()
    val ObtuveLasCategorias: LiveData<Boolean> get() = _ObtuveCategories

    init {
        _ObtuveCategories.value = false
    }


    fun getCategoriesList() {
        println("entro a traer categorias")
        val request = AtikAppService2.buildService(CategoriasRed::class.java)
        val call = request.getCategories()
        var result: Boolean = false

        call.enqueue(object : Callback<List<Categories>> {
            override fun onResponse(
                call: Call<List<Categories>>,
                response: Response<List<Categories>>
            ) {
                if (response.isSuccessful) {

                    _categorias.value = response.body()
                    _ObtuveCategories.value = true
                    println("trayendo categorias")

                    println(response.body().toString())
                } else {
                    println("Result ${response.headers()}")
                    result = false
                    _ObtuveCategories.value = false
                }

            }

            override fun onFailure(call: Call<List<Categories>>, t: Throwable) {
                _ObtuveCategories.value = false
                t.stackTrace
            }

        })
    }

    //locations
    private val _locations = MutableLiveData<List<Locations>>()
    val Locations: LiveData<List<Locations>>
        get() = _locations

    val _getLocations = MutableLiveData<Boolean>()
    val getLocations: LiveData<Boolean>
        get() = _getLocations

    init {

        getLocationsList()
    }

    fun getLocationsList() {
        println("entro a traer ubicaciones")
        val request = AtikAppService2.buildService(LocationsRed::class.java)
        val call = request.getLocations()
        var result: Boolean = false

        call.enqueue(object : Callback<LocationResponse> {
            override fun onResponse(
                call: Call<LocationResponse>,
                response: Response<LocationResponse>
            ) {
                if (response.isSuccessful) {

                    _locations.value = response.body()?.locations
                    _getLocations.value = true
                    println("trayendo ubicaciones")

                    println(response.body()?.locations)
                } else {
                    println("Result ${response.headers()}")
                    result = false
                    _getLocations.value = false
                }

            }

            override fun onFailure(call: Call<LocationResponse>, t: Throwable) {
                _getLocations.value = false
                t.stackTrace
            }

        })
    }


    //promotion
    private val _promotions = MutableLiveData<List<Promotions>>()
    val Promotions: LiveData<List<Promotions>>
        get() = _promotions

    val _getPromotions = MutableLiveData<Boolean>()
    val getPromotions: LiveData<Boolean>
        get() = _getPromotions

    init {
        getPromotionsList()
    }


    fun getPromotionsList() {
        println("entro a traer promociones")
        val request = AtikAppService2.buildService(PromotionsRed::class.java)
        val call = request.getPromotions()
        var result: Boolean = false


        call.enqueue(object : Callback<PromotionsResponse> {
            override fun onFailure(call: Call<PromotionsResponse>, t: Throwable) {
                _getPromotions.value = false
                t.stackTrace
            }

            override fun onResponse(
                call: Call<PromotionsResponse>,
                response: Response<PromotionsResponse>
            ) {
                if (response.isSuccessful) {

                    _promotions.value = response.body()?.promotions
                    _getPromotions.value = true
                    println(response.body()?.promotions)
                } else {
                    println("Result ${response.headers()}")
                    result = false
                    _getPromotions.value = false
                }
            }

        })

    }



    //products
    private val _products = MutableLiveData<List<Product>>()
    val products : LiveData<List<Product>>
        get() = _products

    val _getProducts = MutableLiveData<Boolean>()
    val getProducts: LiveData<Boolean>
        get() = _getProducts

    init {

        getProductsList()
    }

    fun getProductsList() {
        println("entro a traer productos")
        val request = AtikAppService2.buildService(ProductsRed::class.java)
        val call = request.getProductsByCategory()
        var result: Boolean = false

        call.enqueue(object : Callback<ProductResponse> {
            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ) {
                if (response.isSuccessful) {

                    _products.value = response.body()?.products
                    _getProducts.value = true
                    println("trayendo productos")

                    println(response.body()?.products)
                } else {
                    println("Result ${response.headers()}")
                    result = false
                    _getProducts.value = false
                }

            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                _getProducts.value = false
                t.stackTrace
            }

        })
    }

}

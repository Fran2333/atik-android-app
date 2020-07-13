package com.pdm.atikapp.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pdm.atikapp.entity.categories
import com.pdm.atikapp.entity.product
import com.pdm.atikapp.entity.productResponse
import com.pdm.atikapp.interfacesRed.categoriasRed
import com.pdm.atikapp.interfacesRed.productsRed
import com.pdm.atikapp.network.AtikAppService2
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryNetwork {

    //Categorias
    private val _categorias = MutableLiveData<List<categories>>()
    val categorias: LiveData<List<categories>> get() = _categorias

    val _ObtuveCategories = MutableLiveData<Boolean>()
    val ObtuveLasCategorias: LiveData<Boolean> get() = _ObtuveCategories

    init {
        _ObtuveCategories.value = false
    }



    fun getCategoriesList() {
        println("entro a traer categorias")
        val request = AtikAppService2.buildService(categoriasRed::class.java)
        val call = request.getCategories()
        var result: Boolean = false

        call.enqueue(object : Callback<List<categories>> {
            override fun onResponse(
                call: Call<List<categories>>,
                response: Response<List<categories>>
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

            override fun onFailure(call: Call<List<categories>>, t: Throwable) {
                _ObtuveCategories.value = false
                t.stackTrace
            }

        })
    }

    //products
    private val _products = MutableLiveData<List<product>>()
    val products : LiveData<List<product>>
        get() = _products

    val _getProducts = MutableLiveData<Boolean>()
    val getProducts: LiveData<Boolean>
        get() = _getProducts

    init {

        getProductsList()
    }

    fun getProductsList() {
        println("entro a traer productos")
        val request = AtikAppService2.buildService(productsRed::class.java)
        val call = request.getProductsByCategory()
        var result: Boolean = false

        call.enqueue(object : Callback<productResponse> {
            override fun onResponse(
                call: Call<productResponse>,
                response: Response<productResponse>
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

            override fun onFailure(call: Call<productResponse>, t: Throwable) {
                _getProducts.value = false
                t.stackTrace
            }

        })
    }

}

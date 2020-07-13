package com.pdm.atikapp.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pdm.atikapp.entity.*
import com.pdm.atikapp.interfacesRed.categoriasRed
import com.pdm.atikapp.interfacesRed.locationsRed
import com.pdm.atikapp.interfacesRed.loginRed
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

    //locations
    private val _locations = MutableLiveData<List<locations>>()
    val locations: LiveData<List<locations>>
        get() = _locations

    val _getLocations = MutableLiveData<Boolean>()
    val getLocations: LiveData<Boolean>
        get() = _getLocations

    init {

        getLocationsList()
    }

    fun getLocationsList() {
        println("entro a traer ubicaciones")
        val request = AtikAppService2.buildService(locationsRed::class.java)
        val call = request.getLocations()
        var result: Boolean = false

        call.enqueue(object : Callback<locationResponse> {
            override fun onResponse(
                call: Call<locationResponse>,
                response: Response<locationResponse>
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

            override fun onFailure(call: Call<locationResponse>, t: Throwable) {
                _getLocations.value = false
                t.stackTrace
            }

        })
    }
//login
private val _user = MutableLiveData<User>()
    val usuario: LiveData<User> get() = _user
    private val _pass = MutableLiveData<Boolean>()
    val pass: LiveData<Boolean> get() =  _pass

fun Login(nombre: String, password: String){

    var result: Boolean = false
    val request:loginRed = AtikAppService2.buildService(loginRed::class.java)
    val call  = request.getLoginResponse(login(nombre,password))

    call.enqueue(object: Callback<userResponse>{
        override fun onResponse(call: Call<userResponse>, response: Response<userResponse>) {
            if(response.isSuccessful){
                println("Result ${response.headers()}")
                result = response.body()!!.correct
                _pass.value = result
                _user.value =  response.body()!!.usuario
            }else{

                result = false
                _pass.value = result
            }

        }
        override fun onFailure(call: Call<userResponse>, t: Throwable) {
            println(t.message)
            result = false
        }

    })



}

}


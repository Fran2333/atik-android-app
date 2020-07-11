package com.pdm.atikapp.network

import java.sql.Time
import java.util.*

class OrderProperty(
    val id : Int,
    val idCliente : Int,
    val dateEntrega : Date,
    val timeEntrega : Time,
    val subTotal : Double,
    val datePedido : Date,
    val status : String,
    val idLocation : Int,
    val idPromocion : Int
)
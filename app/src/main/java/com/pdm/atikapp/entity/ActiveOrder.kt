package com.pdm.atikapp.entity

import java.sql.Time
import java.util.*

data class ActiveOrder (var id : Int, var type : String, var subtotal : Int, var total : Int, var  deliveryDate : Date, var deliveryTime : Time, var shipping : Int, var inputDate : Date, var state : String)
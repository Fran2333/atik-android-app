package com.pdm.atikapp.atik

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "producto")
data class Producto (
    @PrimaryKey(autoGenerate = true)
    var id_producto: Long,

    @ColumnInfo(name = "nombre")
    var nombre: String,

    @ColumnInfo(name = "precio")
    var precio: Long,

    @ColumnInfo(name = "descripcion")
    var descripcion: String

)
package com.pdm.atikapp.atik

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity( tableName = "usuario")
data class Usuario (

    @PrimaryKey(autoGenerate = true)
    var id_usuario: Long,

    @ColumnInfo(name = "nombre")
    var nombre: String,

    @ColumnInfo(name = "apellido")
    var apellido: String,

    @ColumnInfo(name = "telefono")
    var telefono: String,

    @ColumnInfo(name = "correo")
    var correo: String,

    @ColumnInfo(name = "nombre_usuario")
    var nombre_usuario: String,

    @ColumnInfo(name = "constrasenia")
    var contrasenia: String

)
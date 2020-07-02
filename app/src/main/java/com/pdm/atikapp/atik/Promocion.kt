package com.pdm.atikapp.atik

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "promocion")
data class Promocion(
    @PrimaryKey(autoGenerate = true)
    var id_promocion: Long,

    @ColumnInfo(name = "nombre")
    var nombre: String,

    @ColumnInfo(name = "descuento")
    var descuento: Long
)
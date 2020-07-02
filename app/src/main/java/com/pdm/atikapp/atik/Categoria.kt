package com.pdm.atikapp.atik

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categoria")
data class Categoria (
    @PrimaryKey(autoGenerate = true)
    var id_categoria: Long,

    @ColumnInfo(name = "nombre")
    var nombre: String

)
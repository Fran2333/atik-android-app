package com.pdm.atikapp.atik

import androidx.room.Entity

@Entity(tableName = "productocategoria", primaryKeys = ["id_producto", "id_categoria"])
data class ProductoXCategoria (
    val id_producto: Long,
    val id_categoria: Long
)
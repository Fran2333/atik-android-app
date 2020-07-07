package com.pdm.atikapp.atik

import androidx.room.Entity

@Entity(tableName = "productoorden", primaryKeys = ["id_orden", "id_producto"])
data class ProductoXOrden (
    val id_producto: Long,
    val id_orden: Long
)
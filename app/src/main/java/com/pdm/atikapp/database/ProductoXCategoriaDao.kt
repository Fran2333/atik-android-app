package com.pdm.atikapp.database

import androidx.room.Dao
import androidx.room.Query
import com.pdm.atikapp.atik.Producto

@Dao
interface ProductoXCategoriaDao {
    @Query("SELECT id_producto FROM productoxcategoria WHERE id_categoria =:key")
    fun get(key: Long) : Producto
}
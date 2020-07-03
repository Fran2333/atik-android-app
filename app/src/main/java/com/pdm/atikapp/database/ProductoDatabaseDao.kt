package com.pdm.atikapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.pdm.atikapp.atik.Producto
import java.security.Policy


@Dao
interface ProductoDatabaseDao {
    @Insert
    fun insert(producto: Producto)

    @Update
    fun update(producto: Producto)

    @Query("SELECT nombre, precio, descripcion FROM producto WHERE id_producto =:key")
    fun get(key: Long) :Producto

    @Query("SELECT * FROM producto ORDER BY id_producto DESC")
    fun Ubicaciones(): LiveData<List<Producto>>

}
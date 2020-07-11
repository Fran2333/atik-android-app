package com.pdm.atikapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.pdm.atikapp.atik.Categoria

@Dao
interface CategoriaDatabaseDao {

    @Insert
    fun insert(categoria: Categoria)

    @Update
    fun update (categoria: Categoria)

    @Query("SELECT * FROM categoria WHERE id_categoria=:key")
    fun get(key: Long):Categoria
}

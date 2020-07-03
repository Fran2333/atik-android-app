package com.pdm.atikapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.pdm.atikapp.atik.Rol

@Dao
interface RolDatabaseDao {

    @Insert
    fun insert(rol: Rol)

    @Update
    fun update(rol: Rol)

    @Query("SELECT rol FROM rol WHERE id_rol =:key")
    fun get(key: Long) :Rol?
}
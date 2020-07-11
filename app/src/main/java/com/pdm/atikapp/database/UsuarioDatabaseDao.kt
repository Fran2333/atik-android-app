package com.pdm.atikapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.pdm.atikapp.atik.Usuario


@Dao
interface UsuarioDatabaseDao {

    @Insert
    fun insert(usuario: Usuario)

    @Update
    fun update (usuario: Usuario)

    @Query("SELECT nombre_usuario,nombre, apellido, telefono,correo,constrasenia FROM usuario WHERE id_usuario =:key")
    fun get(key: Long) : Usuario

    @Query("DELETE FROM usuario")
    fun clear()


}
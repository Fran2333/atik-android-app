package com.pdm.atikapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.pdm.atikapp.atik.Ubicacion


@Dao
interface UbicacionDatabaseDao {

    @Insert
    fun insert(ubicacion: Ubicacion)

    @Update
    fun update(ubicacion: Ubicacion)

    @Query("SELECT * FROM ubicacion WHERE id_ubicacion =:key")
    fun get(key: Long): Ubicacion?


    @Query("DELETE FROM ubicacion")
    fun clear()

    @Query("SELECT * FROM ubicacion ORDER BY id_ubicacion DESC")
    fun Ubicaciones(): LiveData<List<Ubicacion>>
}
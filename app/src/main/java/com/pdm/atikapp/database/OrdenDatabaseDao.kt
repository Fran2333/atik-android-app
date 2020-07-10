package com.pdm.atikapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.pdm.atikapp.atik.Orden

@Dao
interface OrdenDatabaseDao {

@Insert
fun insert(orden: Orden)

    @Update
    fun update(orden: Orden)

    @Query("SELECT * FROM orden WHERE id_orden=:key")
    fun get(key: Long):Orden

    @Query("SELECT * FROM orden ORDER BY id_orden DESC")
    fun Ubicaciones(): LiveData<List<Orden>>
}
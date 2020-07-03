package com.pdm.atikapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.pdm.atikapp.atik.Promocion

@Dao
interface PromocionDatabaseDao {

    @Insert
    fun insert(promocion: Promocion)

    @Update
    fun update(promocion: Promocion)

    @Query("SELECT * FROM promocion WHERE id_promocion=:key")
    fun get(key: Long): Promocion

    @Query("DELETE FROM promocion")
    fun clear()

    @Query("SELECT * FROM promocion ORDER BY id_promocion DESC")
    fun Ubicaciones(): LiveData<List<Promocion>>

}
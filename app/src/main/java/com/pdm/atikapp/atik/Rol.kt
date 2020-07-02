package com.pdm.atikapp.atik

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rol")
data class Rol (
    @PrimaryKey(autoGenerate = true)
    var id_rol: Long,

    @ColumnInfo(name = "rol")
    var rol: String
)
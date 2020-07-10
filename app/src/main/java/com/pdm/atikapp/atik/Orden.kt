package com.pdm.atikapp.atik

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.sql.Time
import java.util.*

@Entity(tableName = "orden")
data class Orden (
    @PrimaryKey(autoGenerate = true)
    var id_orden: Long,

    @ForeignKey(entity = Usuario::class, parentColumns = arrayOf("id_usuario"), childColumns = arrayOf("id_cliente"))
    var id_cliente: Long,

    @ColumnInfo(name = "tipo")
    var tipo: String,

    @ColumnInfo(name = "fecha_entrega")
    var fecha_entrega: Date,

    @ColumnInfo(name = "hora_entrega")
    var hora_entrega: Time,

    @ColumnInfo(name = "subtotal")
    var subtotal: Long,

    @ColumnInfo(name = "total")
    var total: Long,

    @ColumnInfo(name = "fecha_pedido")
    var fecha_pedido: Date,

    @ColumnInfo(name = "estado")
    var estado: String,

    @ForeignKey(entity = Ubicacion::class, parentColumns = arrayOf("id_ubicacion"), childColumns = arrayOf("id_ubicacion"))
    var id_ubicacion: Long,

    @ForeignKey(entity = Promocion::class, parentColumns = arrayOf("id_promocion"), childColumns = arrayOf("id_promocion"))
    var id_promocion: Long
    )
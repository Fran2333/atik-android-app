package com.pdm.atikapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pdm.atikapp.atik.Usuario

@Database( entities =  [Usuario::class], version = 1, exportSchema = false)
abstract class AtikDatabase: RoomDatabase() {
}
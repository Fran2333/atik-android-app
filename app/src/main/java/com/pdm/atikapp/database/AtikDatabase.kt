package com.pdm.atikapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pdm.atikapp.atik.Usuario

@Database( entities =  [Usuario::class], version = 1, exportSchema = false)
abstract class AtikDatabase: RoomDatabase() {
    abstract val categoriaDatabaseDao: CategoriaDatabaseDao
    abstract val ordenDatabaseDao: OrdenDatabaseDao
    abstract val productoDatabaseDao: ProductoDatabaseDao
    abstract val promocionDatabaseDao: PromocionDatabaseDao
    abstract val rolDatabaseDao: RolDatabaseDao
    abstract val ubicacionDatabaseDao: UbicacionDatabaseDao
    abstract val usuarioDatabaseDao: UsuarioDatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: AtikDatabase? = null

        fun getInstance(context: Context): AtikDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AtikDatabase::class.java,
                        "atik_database"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE  = instance
                }

                return  instance
            }
        }
    }
}
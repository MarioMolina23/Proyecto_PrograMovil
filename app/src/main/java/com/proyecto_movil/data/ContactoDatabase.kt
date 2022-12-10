package com.proyecto_movil.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.proyecto_movil.model.Contacto

@Database(entities = [Contacto::class],version=1, exportSchema = false)
abstract class ContactoDatabase: RoomDatabase() {

    abstract fun contactoDao() : ContactoDao

    companion object {
        @Volatile
        private var INSTANCE: ContactoDatabase? = null

        fun getDatabase(context: android.content.Context) : ContactoDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }else{
                synchronized(this){
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        ContactoDatabase::class.java,
                        "contacto_database"
                    ).build()
                    INSTANCE = instance
                    return instance
                }
            }
        }
    }
}
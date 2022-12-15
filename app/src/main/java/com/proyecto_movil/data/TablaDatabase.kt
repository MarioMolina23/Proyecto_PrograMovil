package com.proyecto_movil.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.proyecto_movil.model.Tabla

@Database(entities = [Tabla::class],version=1, exportSchema = false)
abstract class TablaDatabase: RoomDatabase() {
    abstract fun tablaDao() : TablaDao

    companion object {
        @Volatile
        private var INSTANCE: TablaDatabase? = null

        fun getDatabase(context: android.content.Context) : TablaDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }else{
                synchronized(this){
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        TablaDatabase::class.java,
                        "tabla_database"
                    ).build()
                    INSTANCE = instance
                    return instance
                }
            }
        }
    }
}
package com.proyecto_movil.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.proyecto_movil.model.Tabla

@Dao
interface TablaDao {

    @Query ("SELECT * FROM TABLA")
    fun getAllData(): LiveData<List<Tabla>> //Revisar

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTabla(tabla: Tabla)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateTabla(tabla: Tabla)

    @Delete
    suspend fun deleteTabla(tabla: Tabla)
}
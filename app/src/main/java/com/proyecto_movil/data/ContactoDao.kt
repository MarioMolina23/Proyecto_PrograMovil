package com.proyecto_movil.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.proyecto_movil.model.Contacto

@Dao
interface ContactoDao {

    @Query ("SELECT * FROM CONTACTO")
    fun getAllData(): LiveData<List<Contacto>> //Revisar

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addContacto(contacto: Contacto)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateContacto(contacto: Contacto)

    @Delete
    suspend fun deleteContacto(contacto: Contacto)
}
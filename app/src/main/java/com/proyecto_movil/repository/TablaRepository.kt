package com.proyecto_movil.repository

import androidx.lifecycle.LiveData
import com.proyecto_movil.data.TablaDao
import com.proyecto_movil.model.Tabla

class TablaRepository(private val tablaDao: TablaDao) {
    var getAllData: LiveData<List<Tabla>> = tablaDao.getAllData()

    suspend fun saveTabla(tabla: Tabla) {
        if(tabla.id==0){
            tablaDao.addTabla(tabla)
        }else{
            tablaDao.updateTabla(tabla)
        }
    }
    suspend fun updateTabla(tabla: Tabla) {


        tablaDao.updateTabla(tabla)
    }

    suspend fun deleteTabla(tabla: Tabla) {
        tablaDao.deleteTabla(tabla)
    }
}
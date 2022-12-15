package com.proyecto_movil.ui

import android.app.Application
import androidx.lifecycle.*
import com.proyecto_movil.data.TablaDao
import com.proyecto_movil.data.TablaDatabase
import com.proyecto_movil.model.Tabla
import com.proyecto_movil.repository.TablaRepository
import kotlinx.coroutines.launch

class TablaViewModel(application: Application) : AndroidViewModel(application) {


    val getAllData : LiveData<List<Tabla>>
    private val repository: TablaRepository
    init {
        val lugarDao = TablaDatabase.getDatabase(application).tablaDao()
        repository = TablaRepository(lugarDao)
        getAllData = repository.getAllData
    }
    fun saveTabla(tabla: Tabla) {
        viewModelScope.launch { repository.saveTabla(tabla) }
    }

    fun deleteTabla(tabla: Tabla) {
        viewModelScope.launch { repository.deleteTabla(tabla)}
    }
}
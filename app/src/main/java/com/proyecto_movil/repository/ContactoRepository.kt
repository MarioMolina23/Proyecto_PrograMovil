package com.proyecto_movil.repository

import androidx.lifecycle.LiveData
import com.proyecto_movil.data.ContactoDao
import com.proyecto_movil.model.Contacto

class ContactoRepository(private val contactoDao: ContactoDao) {
    var getAllData: LiveData<List<Contacto>> = contactoDao.getAllData()

    suspend fun addContacto(contacto: Contacto) {
        contactoDao.addContacto(contacto)
    }

    suspend fun updateContacto(contacto: Contacto) {
        contactoDao.updateContacto(contacto)
    }

    suspend fun deleteContacto(contacto: Contacto) {
        contactoDao.deleteContacto(contacto)
    }
}
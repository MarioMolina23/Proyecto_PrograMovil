package com.proyecto_movil.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "contacto")
data class Contacto(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name="nombre")
    val nombre: String,
    @ColumnInfo(name="correo")
    val correo: String,
    @ColumnInfo(name="telefono")
    val telefono: String,
    @ColumnInfo(name="comentario")
    val comentario: String
) : Parcelable

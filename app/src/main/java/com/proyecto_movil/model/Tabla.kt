package com.proyecto_movil.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "tabla")
data class Tabla(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name="bus")
    val bus: String?,
    @ColumnInfo(name="precio")
    val precio: Int?,
    @ColumnInfo(name="dias")
    val dias: String?,
    @ColumnInfo(name="horario")
    val horario: String?,
    @ColumnInfo(name="descripcion")
    val descripcion: String?
) : Parcelable

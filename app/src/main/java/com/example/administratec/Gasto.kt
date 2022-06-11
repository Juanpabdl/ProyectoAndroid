package com.example.administratec

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Gasto")
data class Gasto(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "fecha") val fecha: Date,
    @ColumnInfo(name = "costo") val costo: Long,
    @ColumnInfo(name = "concepto") val concepto: String,
    @ColumnInfo(name = "categoria") val categoria: String
    )
package com.example.administratec

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import java.util.*

@Dao
interface GastosDao {
    @Query("SELECT * FROM gasto")
    suspend fun obtenerGastos(): List<Gasto>

    @Query("SELECT * FROM gasto WHERE categoria = :categoria")
    suspend fun obtenerGastosPorCategoria(categoria: String): List<Gasto>

    @Query("SELECT * FROM gasto WHERE fecha BETWEEN :inicio AND :fin")
    suspend fun obtenerGastosPorFecha(inicio: Date, fin: Date): List<Gasto>

    @Insert
    suspend fun agregarGasto(gasto: Gasto)

    @Delete
    suspend fun eliminaGasto(gasto: Gasto)
}
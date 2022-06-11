package com.example.administratec

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GastosDao {
    @Query("SELECT * FROM gasto")
    suspend fun obtenerGastos(): List<Gasto>

    @Query("SELECT * FROM gasto WHERE categoria = :categoria")
    suspend fun obtenerGastosPorCategoria(categoria: String): List<Gasto>
/*
    @Query("SELECT * FROM gasto WHERE fecha")
    suspend fun obtenerGatosSemanales(): List<Gasto>

    @Query("SELECT * FROM gasto Where fecha")
    suspend fun obtenerGastosMensuales(): List<Gasto>
*/
    @Insert
    suspend fun agregarGasto(gasto: Gasto)

    @Delete
    suspend fun eliminaGasto(gasto: Gasto)
}
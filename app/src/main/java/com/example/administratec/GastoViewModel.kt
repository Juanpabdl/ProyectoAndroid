package com.example.administratec

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.util.*

class GastoViewModel(private val gastoDao: GastosDao): ViewModel() {

    suspend fun obtenerGastos() = gastoDao.obtenerGastos()

    suspend fun obtenerGastosPorCategoria(categoria: String) = gastoDao.obtenerGastosPorCategoria(categoria)

    suspend fun obtenerGastosPorFecha(inicio: Date, fin: Date) = gastoDao.obtenerGastosPorFecha(inicio,fin)

    suspend fun agregarGasto(gasto: Gasto) = gastoDao.agregarGasto(gasto)

    suspend fun eliminarGasto(gasto:Gasto) = gastoDao.eliminaGasto(gasto)
}

class GastoViewModelFactory(private val gastoDao: GastosDao): ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GastoViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return GastoViewModel(gastoDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
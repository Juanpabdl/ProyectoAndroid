package com.example.administratec

import androidx.lifecycle.ViewModel
import java.util.*

class PercentagesViewModel : ViewModel() {
    public var comprap: Int = 20
    public var casap: Int = 20
    public var elecp: Int = 20
    public var alimp: Int = 20
    public var edup: Int = 20
    public val compras: String = "Compras"
    public val casa: String = "Casa"
    public val electronicos: String = "Electronicos"
    public val alimentos: String = "Alimentos"
    public val educacion: String = "Educacion"

    fun changecompra(cantidadc: Int,cantidadca: Int,cantidadele: Int,cantidadali: Int,cantidadedu: Int){
        comprap = cantidadc
        casap = cantidadca
        elecp = cantidadele
        alimp = cantidadali
        edup = cantidadedu
    }
}
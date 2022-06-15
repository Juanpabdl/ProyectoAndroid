package com.example.administratec

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.administratec.databinding.ItemGastoBinding
import java.text.SimpleDateFormat

class Adapter(var gasto: List<Gasto>): RecyclerView.Adapter<Adapter.ViewHolder>(){
    class ViewHolder (val binding : ItemGastoBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemGastoBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            val fecha = gasto[position].fecha
            val spf = SimpleDateFormat("EEE, dd-MM-yyyy")
            val fecha_good = spf.format(fecha)
            textViewFecha.text = fecha_good
            when (gasto[position].categoria) {
                "Compras" -> textViewFecha.setBackgroundColor(Color.parseColor("#EC4A18"))
                "Casa" -> textViewFecha.setBackgroundColor(Color.parseColor("#0F3AD3"))
                "Electronicos" -> textViewFecha.setBackgroundColor(Color.parseColor("#FFC107"))
                "Alimentacion" -> textViewFecha.setBackgroundColor(Color.parseColor("#2196F3"))//"#2196F3"
                "Educacion" -> textViewFecha.setBackgroundColor(Color.parseColor("#4CAF50"))
            }
            textViewFecha.setTextColor((Color.parseColor(("#FFFFFF"))))
            textViewDesc.text = gasto[position].concepto
            textViewCosto.text = "$" + gasto[position].costo.toString()
        }
    }

    override fun getItemCount(): Int {
        return gasto.size
    }
}
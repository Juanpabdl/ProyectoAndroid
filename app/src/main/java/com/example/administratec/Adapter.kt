package com.example.administratec

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.administratec.databinding.ItemGastoBinding

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
            textViewFecha.text = gasto[position].fecha.toString()
            textViewDesc.text = gasto[position].concepto
            textViewCosto.text = "$" + gasto[position].costo.toString()
        }
    }

    override fun getItemCount(): Int {
        return gasto.size
    }
}
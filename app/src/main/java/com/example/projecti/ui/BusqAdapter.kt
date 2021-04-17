package com.example.projecti.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projecti.databinding.ContactoRowBinding
import com.example.projecti.model.Contacto

class BusqAdapter:RecyclerView.Adapter<BusqAdapter.Holderi>(){

    private var contData= emptyList<Contacto>()

    class Holderi (val binding: ContactoRowBinding):RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holderi {
        return Holderi(
            ContactoRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
       return contData.size
    }

    override fun onBindViewHolder(holder: Holderi, position: Int) {
            holder.binding.imageView
            holder.binding.testo1.text=contData[position].nombre
            holder.binding.testo2.text=contData[position].direccion
            holder.binding.testo3.text=contData[position].mail
    }
    fun setData(newData:List<Contacto>){
         contData=newData
        notifyDataSetChanged()

    }
}
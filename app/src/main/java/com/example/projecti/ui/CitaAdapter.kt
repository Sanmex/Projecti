package com.example.projecti.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.projecti.R
import com.example.projecti.databinding.ItemcitaBinding
import com.example.projecti.model.Cita
import com.example.projecti.model.Converters
import java.util.*


class CitaAdapter :RecyclerView.Adapter<CitaAdapter.Myvh>(){
    private var citaList= emptyList<Cita>()



    class Myvh(itemi: View):RecyclerView.ViewHolder(itemi) {
            var binding =ItemcitaBinding.bind(itemi)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): Myvh {
        return Myvh(
            LayoutInflater.from(viewGroup.context).inflate(R.layout.itemcita,viewGroup,false)
        )
    }

    override fun getItemCount()=citaList.size

    override fun onBindViewHolder(holder: Myvh, position: Int) {

          val itemcita=citaList[position]

        holder.binding.contacto.text=itemcita.contactoId.toString()
        var uno=itemcita.fechahora
        holder.binding.fecha.text=uno.toString()

        holder.binding.estado.text=itemcita.estado

        holder.binding.mapa.setOnClickListener {
             holder.binding.mapa.findNavController().navigate(R.id.action_citasList_to_mapFrag)
        }

        holder.binding.layoutcita.setOnClickListener {
            holder.binding.layoutcita.findNavController().navigate(R.id.action_citasList_to_citasFragment)
        }


    }

    fun setDate(cita:List<Cita>){
        this.citaList=cita
        notifyDataSetChanged()
    }



}
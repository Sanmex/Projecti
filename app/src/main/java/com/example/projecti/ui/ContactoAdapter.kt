package com.example.projecti.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.projecti.R
import com.example.projecti.databinding.ContactoRowBinding
import com.example.projecti.model.Contacto



class ContactoAdapter: RecyclerView.Adapter<ContactoAdapter.MyViewHolder>() {

    //varianble lista
    private var contactList= emptyList<Contacto>()




    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
          var binding =ContactoRowBinding.bind(itemView)


    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(viewGroup.context).inflate(R.layout.contacto_row, viewGroup, false)
        )
    }

    override fun getItemCount()=contactList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
          val currentItem=contactList[position]

          holder.binding.imageView
          holder.binding.testo1.text= currentItem.nombre
          holder.binding.testo2.text=currentItem.direccion
          holder.binding.testo3.text=currentItem.mail

          holder.binding.layito.setOnClickListener {
              val action=ContactoFragmentDirections.actionContactoFragmentToEditarFragment(currentItem)
              holder.binding.layito.findNavController().navigate(action)//posible error

          }
          holder.binding.cita.setOnClickListener {
           val actionr=ContactoFragmentDirections.actionContactoFragmentToCitasFragment(currentItem)
           holder.binding.cita.findNavController().navigate(actionr)
        }
    }

     fun setDate(contacto:List<Contacto>){
         this.contactList=contacto
         notifyDataSetChanged()
     }



    }

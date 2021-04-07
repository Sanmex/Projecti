package com.example.projecti.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projecti.R
import com.example.projecti.databinding.ContactoRowBinding
import com.example.projecti.model.Contacto
import com.example.projecti.model.ContactoItem


class ContactoAdapter ( ): RecyclerView.Adapter<ContactoAdapter.MyViewHolder>() {

    //varianble lista
    private var contactoList= emptyList<Contacto>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
          var binding =ContactoRowBinding.bind(itemView)
          var contexto=itemView.context
           /*val imageView:ImageView=binding.imageView
           val textView:TextView=binding.testo1
           val textView2:TextView=binding.testo2
           val textView3:TextView=binding.testo3*/



    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(viewGroup.context).inflate(R.layout.contacto_row, viewGroup, false)
        )
    }

    override fun getItemCount()=contactoList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
          val currentItem=contactoList[position]
          holder.binding.imageView
          holder.binding.testo1.text=currentItem.nombre.toString()
          holder.binding.testo2.text=currentItem.direccion.toString()
          holder.binding.testo3.text=currentItem.mail.toString()
    }

     fun setDate(contacto:List<Contacto>){
         this.contactoList=contacto
         notifyDataSetChanged()
     }



    }

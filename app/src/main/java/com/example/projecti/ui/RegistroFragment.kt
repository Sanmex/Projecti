package com.example.projecti.ui

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.projecti.R
import com.example.projecti.databinding.FragmentRegistroBinding
import com.example.projecti.model.Contacto
import com.example.projecti.vm.MainViewModel


class RegistroFragment : Fragment() {

    private var _binding:FragmentRegistroBinding?=null
    private val binding get() = _binding!!
    private lateinit var vm :MainViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentRegistroBinding.inflate(inflater,container,false)

        val view=binding.root
        vm=ViewModelProvider(this).get(MainViewModel::class.java)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       binding.btnreg.setOnClickListener {
           insertDataTodb()
       }


    }
    private fun insertDataTodb(){
     //get the text of the edit text
        val nombre=binding.nombreEt.text.toString()
        val direccion=binding.direccionEt.text.toString()
        val email=binding.mailEt.text.toString()
        if(inputCheck(nombre, direccion, email)){
            //si true se crea contacto
            val contacto= Contacto(0L,nombre,direccion,email)
            vm.saveContact(contacto)
            Toast.makeText(requireContext(),"Ya se guardo",Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_registroFragment_to_citasFragment)
        }else{
            Toast.makeText(requireContext(),"Llene todos los campos",Toast.LENGTH_SHORT).show()
        }
    }


    private fun inputCheck(nombre:String,direccion:String,email:String):Boolean{
        return !(TextUtils.isEmpty(nombre) && TextUtils.isEmpty(direccion) && TextUtils.isEmpty(email))
    }
}



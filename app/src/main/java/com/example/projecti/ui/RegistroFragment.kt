package com.example.projecti.ui


import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.projecti.R
import com.example.projecti.databinding.FragmentRegistroBinding
import com.example.projecti.model.*
import com.example.projecti.vm.MainViewModel
import kotlinx.coroutines.launch



class RegistroFragment : androidx.fragment.app.Fragment() {

    private var _binding:FragmentRegistroBinding?=null
    private val binding get() = _binding!!
    private lateinit var vm : MainViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding= FragmentRegistroBinding.inflate(inflater,container,false)

        val view=binding.root
        vm= ViewModelProvider(this).get(MainViewModel::class.java)

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

              savito(contacto)
             Toast.makeText(context,"Id $id se ha insertado", Toast.LENGTH_SHORT).show()



             Toast.makeText(requireContext(),"Ya se guardo",Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_registroFragment_to_contactoFragment)
        }else{
            Toast.makeText(requireContext(),"Llene todos los campos",Toast.LENGTH_SHORT).show()
        }
    }


    private fun inputCheck(nombre:String,direccion:String,email:String):Boolean{
        return !(TextUtils.isEmpty(nombre) && TextUtils.isEmpty(direccion) && TextUtils.isEmpty(email))
    }
    //por que solo fùnciono con lifecycle

     private fun savito(contacto: Contacto) = lifecycleScope.launch {

        val id = vm.saveContact(contacto)
       // Toast.makeText(context,"Id $id se ha insertado", Toast.LENGTH_SHORT).show()

        val tel1=binding.tel1.text.toString()
        val tipo1=binding.tipo1.text.toString()
        val tel2=binding.tel2.text.toString()
        val tipo2=binding.tipo2.text.toString()
        val telefonos=Telefonos(0L,tel1,tipo1,id)
        val telefonos1=Telefonos(0L,tel2,tipo2,id)
        vm.saveTelList(telefonos)
        vm.saveTelList(telefonos1)

        val puesto=binding.puesto.text.toString()
        val sueldo=binding.salario.text.toString()
        val horario="7am a 9am"
        val oferta= Oferta(0L,puesto,sueldo,horario,id)
        vm.saveOfer(oferta)




    }


}



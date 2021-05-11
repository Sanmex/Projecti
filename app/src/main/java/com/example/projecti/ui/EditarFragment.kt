package com.example.projecti.ui

import android.app.AlertDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.projecti.R
import com.example.projecti.databinding.FragmentEditarBinding
import com.example.projecti.model.Contacto
import com.example.projecti.vm.MainViewModel
import kotlinx.android.synthetic.main.fragment_editar.*


class EditarFragment : Fragment() {
    private var _binding:FragmentEditarBinding?=null
    private val binding get() = _binding!!
    private lateinit var mainViewModel: MainViewModel
    private val args by navArgs<EditarFragmentArgs>()





    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        _binding= FragmentEditarBinding.inflate(inflater,container,false)
        val view=binding.root
        //set text
        mainViewModel=ViewModelProvider(this).get(MainViewModel::class.java)

        binding.editnom.setText(args.currentContact.nombre)
        binding.editDirec.setText(args.currentContact.direccion)
        binding.editMail.setText(args.currentContact.mail)
         gettel()








        binding.btnedit.setOnClickListener {
              updateItem()
        }
        //add menu

        setHasOptionsMenu(true)
        return view
    }


    private fun updateItem(){
        val nombre=editnom.text.toString()
        val direccion=editDirec.text.toString()
        val email=editMail.text.toString()

       if(inputCheck(nombre ,direccion,email)){
           //primero se crea el objeto contacto
           val updateContact= Contacto(args.currentContact.id,nombre,direccion,email)
           //desapues se llama a la funcion update

            mainViewModel.editarContacto(updateContact)
           Toast.makeText(requireContext(),"Editado con exitos",Toast.LENGTH_SHORT).show()
           //de retro a la lista
           findNavController().navigate(R.id.action_editarFragment_to_contactoFragment)

       }else{
           Toast.makeText(requireContext(),"Rellene los campos",Toast.LENGTH_SHORT).show()
       }

    }
    private fun inputCheck(nombre:String,direccion:String,email:String):Boolean{
        return !(TextUtils.isEmpty(nombre) && TextUtils.isEmpty(direccion) && TextUtils.isEmpty(email))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_bar,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.delete){
            deleteContacto()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteContacto(){
        val builder =AlertDialog.Builder(requireContext())
        builder.setPositiveButton("yes"){ _,_->
             mainViewModel.borrarContacto(args.currentContact)
            Toast.makeText(requireContext(),"Removido",Toast.LENGTH_SHORT).show()
            //pa la lista otra vez
            findNavController().navigate(R.id.action_editarFragment_to_contactoFragment)
        }
        builder.setNegativeButton("nop"){ _,_ ->}
         builder.setTitle("Delete ${args.currentContact.nombre}")
            builder.setMessage("Are you sure? You will delete ${args.currentContact.nombre}")
            builder.create().show()

    }
    /*private fun ofertin(puesto:String,salario:String,horario:String){
        val conid=args.currentContact.id
        val oferta=Oferta(0L,puesto,salario,horario,conid)
        binding.puesto.setText(puesto)
        binding.horario.setText(horario)
        binding.sueldo.setText(salario)

        SE TIENE QUE BUSCAR EL CONTACTO
    }*/

    private fun gettel() {
        mainViewModel.getContTel(args.currentContact.id)
                .observe(viewLifecycleOwner, Observer { telists ->
                   // si son mas campos necesarios para la lista se podria hacer variable para el index
                    binding.tel1.setText(telists.teles[0].numero)
                    binding.tel2.setText(telists.teles[1].numero)
                })
    }











}

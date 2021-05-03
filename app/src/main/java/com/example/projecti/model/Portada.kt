package com.example.projecti.model

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.projecti.R
import com.example.projecti.databinding.FragmentPortadaBinding


class Portada : Fragment() {
    private var _binding:FragmentPortadaBinding?=null
    private val binding get()=_binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentPortadaBinding.inflate(inflater,container,false)
        val view=binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btncont.setOnClickListener {
            findNavController().navigate(R.id.action_portada_to_contactoFragment)
        }
        binding.btncita.setOnClickListener{
            findNavController().navigate(R.id.action_portada_to_citasList)
        }

    }
}
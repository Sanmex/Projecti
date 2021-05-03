package com.example.projecti.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projecti.databinding.FragmentCitasListBinding
import com.example.projecti.vm.MainViewModel


class CitasList : Fragment() {

    private var _binding: FragmentCitasListBinding? = null
    private val binding get() = _binding!!
    private lateinit var mainViewModel: MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCitasListBinding.inflate(inflater, container, false)
        val view = binding.root

        val adapter = CitaAdapter()
        val recyclerView = binding.reciclele
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //viewmodel
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.listacita().observe(viewLifecycleOwner, Observer { cita ->
            adapter.setDate(cita)


        })



        return view

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }



}




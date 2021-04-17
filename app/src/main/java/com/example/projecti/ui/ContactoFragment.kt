package com.example.projecti.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projecti.R
import com.example.projecti.databinding.FragmentContactoBinding
import com.example.projecti.vm.MainViewModel


class ContactoFragment : Fragment()  {
    private var _binding: FragmentContactoBinding? = null
    private val binding get() = _binding!!
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContactoBinding.inflate(inflater, container, false)
        val view = binding.root

        val adapter = ContactoAdapter()
        val recyclerView = binding.mirecyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //viewmodel
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.getContacList().observe(viewLifecycleOwner, Observer { contacto ->
            adapter.setDate(contacto)



        })



        return view

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        binding.btnflo.setOnClickListener {
            findNavController().navigate(R.id.action_contactoFragment_to_registroFragment)
        }
    }


}













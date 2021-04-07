package com.example.projecti.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.projecti.R
import com.example.projecti.databinding.FragmentContactoBinding


class ContactoFragment : Fragment() {
    private var _binding: FragmentContactoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContactoBinding.inflate(inflater, container, false)
        val view = binding.root

        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnflo.setOnClickListener {
            findNavController().navigate(R.id.action_contactoFragment_to_registroFragment)
        }
    }



}

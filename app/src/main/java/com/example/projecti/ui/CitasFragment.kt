package com.example.projecti.ui

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.projecti.R
import com.example.projecti.databinding.FragmentCitasBinding
import com.example.projecti.model.Cita
import com.example.projecti.vm.MainViewModel
import java.util.*


class CitasFragment : Fragment(),DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener {


    private var _binding: FragmentCitasBinding?=null
    private val binding get() = _binding!!
    private lateinit var vmc :MainViewModel
    private val args by navArgs<CitasFragmentArgs>()


//revisar loli
     val loli= arguments?.getLong("id")

             var day=0
             var month=0
             var year=0
             var hour=0
             var minute=0


    var saveDay=0
    var saveMonth=0
    var saveYear=0
    var saveHour=0
    var saveMinute=0






    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= FragmentCitasBinding.inflate(inflater,container,false)

        val view=binding.root
        vmc= ViewModelProvider(this).get(MainViewModel::class.java)
        return view
        // Inflate the layout for this fragment

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // binding.contacto.setText(args.actuslcont.nombre)
           showCita()
           pickDate()
        binding.btnhecho.setOnClickListener {
           val conid=args.actuslcont.id
            val a=saveYear
            val me=saveMonth
            val di=saveDay
            val ho=saveHour
            val min=saveMinute
            val cal =Calendar.getInstance ()
            cal.set(a,me,di,ho,min)
            val cita=Cita(0L,cal.time,"yaaa",conid)


            vmc.saveCitaList(cita)

            Toast.makeText(requireContext(),"ya me guarde",Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_citasFragment_to_citasList)


        }
        //añadir texto clickable a las cardview para enlazar contacto y cita.


    }



    private fun pickDate() {
        binding.brnreloj.setOnClickListener {
            getDateTimeCalendar()
            DatePickerDialog(requireContext(), this, year, month, day).show()

        }
    }
    private fun getDateTimeCalendar(){
        val calendar= Calendar.getInstance()
        day=calendar.get(Calendar.DAY_OF_MONTH)
        month=calendar.get(Calendar.MONTH)
        year=calendar.get(Calendar.YEAR)
        hour=calendar.get(Calendar.HOUR)
        minute=calendar.get(Calendar.MINUTE)
    }

        override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
            saveDay = dayOfMonth
            saveMonth = month+1
            saveYear = year

            getDateTimeCalendar()
            TimePickerDialog(requireContext(), this, hour, minute, true).show()
        }

        override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
            saveHour = hourOfDay
            saveMinute = minute

            binding.tvReloj.text = "$saveDay-$saveMonth-$saveYear\n Hour: $saveHour-Minute:$saveMinute"





        }
       private fun showCita() {
        //mejor no editar acua
         vmc.getContactCita(args.actuslcont.id).observe(viewLifecycleOwner, androidx.lifecycle.Observer { citalists ->
                         binding.contacto.setText(citalists.citas[0].fechahora.toString())

                     })
                 }

    }









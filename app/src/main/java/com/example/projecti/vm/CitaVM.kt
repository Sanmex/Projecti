package com.example.projecti.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.projecti.model.Cita
import com.example.projecti.repositorios.RepoCita
import com.example.projecti.repositorios.RepoCitaImpl
import com.example.projecti.repositorios.RepositorioImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.launch


class CitaVM (application: Application):AndroidViewModel(application){
    private val repoCita:RepoCita = RepoCitaImpl(application)
    //contacto
    private val contactoRepo=RepositorioImp(application)//para iniciar lista
    //listacitas
    val citalistas=repoCita.listaCitas()
    //revisar si necesario iniciar aqui lista de contactos
    val contactos=contactoRepo.readAllData()
    //las listas con id
    private val citasId=MutableLiveData<Long>()

    //long guarda los id
    fun saveCitaList(cita: Cita):MutableLiveData<Long>{
        viewModelScope.launch(Dispatchers.IO) {
            citasId.value=repoCita.guardarCita(cita)
        }
        return citasId
    }

    fun editarCita(cita: Cita){
        viewModelScope.launch(Dispatchers.IO ) {
            repoCita.editarCita(cita)
        }
    }
    fun borrarCita(cita: Cita){
        viewModelScope.launch (Dispatchers.IO){
            repoCita.borrarCita(cita)
        }
    }
    //ver data class lista diferente para alreves citasContacto
}
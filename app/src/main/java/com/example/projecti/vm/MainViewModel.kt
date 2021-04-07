package com.example.projecti.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.projecti.model.*
import com.example.projecti.repositorios.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) :AndroidViewModel(application){

   private val repositorio:Repositorio=RepositorioImp(application)
    val contactos=repositorio.readAllData()
    private val repoTel: RepoTel = RepoTelImpl(application)
    private val telid = MutableLiveData<Long>()
    private val repoOferta:RepoOferta=RepoOfertaImpl(application)

    //guardar contacto
    fun saveContact(contacto: Contacto){
        viewModelScope.launch (Dispatchers.IO){
            repositorio.addContacto(contacto)
        }
    }
    fun editarContacto(contacto: Contacto){
        viewModelScope.launch (Dispatchers.IO){
            repositorio.editarContacto(contacto)
        }
    }
    fun borrarContacto(contacto: Contacto){
        viewModelScope.launch (Dispatchers.IO){
            repositorio.borrarContacto(contacto)
        }
    }

    fun saveTelList(telefonos: Telefonos): MutableLiveData<Long> {
        viewModelScope.launch {
            telid.value = repoTel.guardartel(telefonos)
        }
        return telid
    }

    fun editarTel(telefonos: Telefonos) {
        viewModelScope.launch(Dispatchers.IO) {
            repoTel.editarTel(telefonos)
        }

    }

    fun saveOfer(oferta: Oferta){
        viewModelScope.launch (Dispatchers.IO){
            repoOferta.guardarOfer(oferta)
        }
    }
    fun editarOferta(oferta: Oferta){
        viewModelScope.launch(Dispatchers.IO) {
            repoOferta.editarOferta(oferta)
        }
    }
    //borrar oferta en cascada con contacto.

       //obtener contacto


    //listasrelacionales

    fun getContaCita(cid:Long):LiveData<List<ContactoAndCita>> = repositorio.getContCitas(cid)

    fun getContTel(cid:Long):LiveData<List<ContactoAndTel>> = repositorio.getConTel(cid)

    fun getContacList():LiveData<List<Contacto>> = repositorio.readAllData()

}
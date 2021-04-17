package com.example.projecti.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.projecti.model.*
import com.example.projecti.repositorios.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(application: Application) :AndroidViewModel(application){

   private val repositorio:Repositorio=RepositorioImp(application)
    private val repoTel: RepoTel = RepoTelImpl(application)
    private var contId:Long=0L
    private val repoOferta:RepoOferta=RepoOfertaImpl(application)


    //busqueda



    suspend fun saveContact(contacto: Contacto) = withContext(Dispatchers.IO) {
        repositorio.addContacto(contacto)
    }
    //guardar contacto con id
   /* fun saveContact(contacto: Contacto):Long{
        viewModelScope.launch (Dispatchers.IO){
            repositorio.addContacto(contacto)


        }
        return contId
    }*/
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

    fun saveTelList(telefonos: Telefonos) {
        viewModelScope.launch {
            repoTel.guardartel(telefonos)
        }

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

     fun searchDatabase(searchQuery:String):LiveData<List<Contacto>> = repositorio.searchDatabase(searchQuery)
    //listasrelacionales

    fun getContaCita(cid:Long):LiveData<List<ContactoAndCita>> = repositorio.getContCitas(cid)

    fun getContTel(cid:Long):LiveData<List<ContactoAndTel>> = repositorio.getConTel(cid)

    fun getContacList():LiveData<List<Contacto>> = repositorio.readAllData()

    fun getId() = repositorio.getId()







}
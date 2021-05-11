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
import kotlinx.coroutines.withContext

class MainViewModel(application: Application) :AndroidViewModel(application){

   private val repositorio:Repositorio=RepositorioImp(application)
    private val repoTel: RepoTel = RepoTel.RepoTelImpl(application)
    private var contId:Long=0L
    private val repoOferta:RepoOferta=RepoOfertaImpl(application)

    private val repoCita:RepoCita = RepoCitaImpl(application)
    //contacto
    private val contactoRepo=RepositorioImp(application)//para iniciar lista
    //listacitas
    //val citalistas=repoCita.listaCitas()
    //revisar si necesario iniciar aqui lista de contactos
    val contactos=contactoRepo.readAllData()
    //las listas con id
    private val citasId= MutableLiveData<Long>()
    var parametroBusqueda=MutableLiveData<String>()
    var contaList=MutableLiveData<List<Contacto>>()



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

   // fun getContaCita(cid:Long):LiveData<List<ContactoAndCita>> = repositorio.getContCitas(cid)


    fun getContacList():LiveData<List<Contacto>> = repositorio.readAllData()

    fun getContactCita(cid:Long):LiveData<ContactoAndCita> = repositorio.getContCitas(cid)

    fun getContTel(cid: Long):LiveData<ContactowithTel> = repositorio.fetchconTel(cid)


    fun getId() = repositorio.getId()

    //long guarda los id
    fun saveCitaList(cita: Cita) {
        viewModelScope.launch(Dispatchers.IO) {
            repoCita.guardarCita(cita)
        }

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
    fun listacita():LiveData<List<Cita>> = repoCita.listaCitas()


    fun buscar(query:String) :LiveData<List<Contacto>> = repositorio.searchDatabase(query)


}
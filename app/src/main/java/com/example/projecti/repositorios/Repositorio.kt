package com.example.projecti.repositorios

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.projecti.config.AppDatabase
import com.example.projecti.domain.ContactoDao
import com.example.projecti.model.Contacto
import com.example.projecti.model.ContactoAndCita
import com.example.projecti.model.ContactowithTel


interface Repositorio {
    fun readAllData():LiveData<List<Contacto>>
    fun getContCitas(contacto: Long):LiveData<ContactoAndCita>
    suspend fun addContacto(contacto: Contacto):Long
   fun fetchconTel(cid: Long):LiveData<ContactowithTel>
    suspend fun editarContacto(contacto: Contacto)
    suspend fun borrarContacto(contacto: Contacto)
    fun searchDatabase(searchQuery:String):LiveData<List<Contacto>>
    fun getId():Long
}
class RepositorioImp (application: Application):
    Repositorio {
    private val contactoDao: ContactoDao by lazy{
        AppDatabase.getDatabase(application).contactoDao()
    }
    override  fun readAllData(): LiveData<List<Contacto>> =contactoDao.listaContactos()


    override fun getContCitas(cid: Long): LiveData<ContactoAndCita> =contactoDao.listaEmpresaCitas(cid)



     override suspend fun addContacto(contacto: Contacto):Long=contactoDao.guardarContact(contacto)
     override fun fetchconTel(cid: Long): LiveData<ContactowithTel> = contactoDao.getTelecont(cid)


     override suspend fun editarContacto(contacto: Contacto) =contactoDao.editarContact(contacto)

    override suspend fun borrarContacto(contacto: Contacto) =contactoDao.borrarContacto(contacto)

    override fun searchDatabase(searchQuery: String): LiveData<List<Contacto>> = contactoDao.searchDatabase(searchQuery)
    override fun getId()=contactoDao.getById()


}
//posible error por la diferente configuracion de la database ,si falla copiar del ejemplo play list
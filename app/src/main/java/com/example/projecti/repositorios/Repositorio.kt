package com.example.projecti.repositorios

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.projecti.config.AppDatabase
import com.example.projecti.domain.ContactoDao
import com.example.projecti.model.Contacto
import com.example.projecti.model.ContactoAndCita
import com.example.projecti.model.ContactoAndTel

interface Repositorio {
    fun readAllData():LiveData<List<Contacto>>
    fun getContCitas(contacto: Long):LiveData<List<ContactoAndCita>>
    suspend fun addContacto(contacto: Contacto)
    fun getConTel(contacto: Long):LiveData<List<ContactoAndTel>>
    suspend fun editarContacto(contacto: Contacto)
    suspend fun borrarContacto(contacto: Contacto)
}
class RepositorioImp (application: Application):
    Repositorio {
    private val contactoDao: ContactoDao by lazy{
        AppDatabase.getDatabase(application)!!.contactoDao()
    }
    override  fun readAllData(): LiveData<List<Contacto>> =contactoDao.listaContactos()


    override fun getContCitas(cid: Long): LiveData<List<ContactoAndCita>> =contactoDao.listaEmpresaCitas(cid)



    override suspend fun addContacto(contacto: Contacto)=contactoDao.guardarContact(contacto)


    override fun getConTel(cid: Long): LiveData<List<ContactoAndTel>> =contactoDao.listaEmpresaTelefonos(cid)

    override suspend fun editarContacto(contacto: Contacto) =contactoDao.editarContact(contacto)

    override suspend fun borrarContacto(contacto: Contacto) =contactoDao.borrarContacto(contacto)


}
//posible error por la diferente configuracion de la database ,si falla copiar del ejemplo play list
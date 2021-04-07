package com.example.projecti.repositorios

import android.app.Application
import com.example.projecti.config.AppDatabase
import com.example.projecti.domain.TelefonoDao
import com.example.projecti.model.Telefonos

interface RepoTel {
    suspend fun guardartel(telefonos: Telefonos):Long
    suspend fun editarTel(telefonos: Telefonos)
    suspend fun borrartel(telefonos: Telefonos)
}
class RepoTelImpl(application: Application):RepoTel{
    private val telefonoDao:TelefonoDao by lazy{
        AppDatabase.getDatabase(application)!!.telefonoDao()
    }

    override suspend fun guardartel(telefonos: Telefonos):Long =telefonoDao.guardarTelefonos(telefonos)

    override suspend fun editarTel(telefonos: Telefonos) =telefonoDao.editarTelefonos(telefonos)

    override suspend fun borrartel(telefonos: Telefonos) =telefonoDao.borrarTelefonos(telefonos)
}
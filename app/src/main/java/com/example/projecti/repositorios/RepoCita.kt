package com.example.projecti.repositorios

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.projecti.config.AppDatabase
import com.example.projecti.domain.CitaDao
import com.example.projecti.model.Cita

interface RepoCita {
    suspend fun guardarCita(cita: Cita):Long
    suspend fun editarCita(cita: Cita)
    suspend fun borrarCita(cita: Cita)
    fun listaCitas():LiveData<List<Cita>>
}
class RepoCitaImpl(application: Application):RepoCita{

    private val citaDao:CitaDao by lazy{
        AppDatabase.getDatabase(application)!!.citaDao()
    }

    override suspend fun guardarCita(cita: Cita):Long =citaDao.guardarCitas(cita)

    override suspend fun editarCita(cita: Cita) =citaDao.editarCitas(cita)

    override suspend fun borrarCita(cita: Cita) =citaDao.borrarCitas(cita)

    override fun listaCitas(): LiveData<List<Cita>> =citaDao.listaCitas()
}
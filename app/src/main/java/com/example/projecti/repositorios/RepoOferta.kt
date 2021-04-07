package com.example.projecti.repositorios

import android.app.Application
import com.example.projecti.config.AppDatabase
import com.example.projecti.domain.OfertaDao
import com.example.projecti.model.Oferta

interface RepoOferta {
    suspend fun guardarOfer(oferta: Oferta)
    suspend fun editarOferta(oferta: Oferta)
    suspend fun borrarOferta(oferta: Oferta)
}
class RepoOfertaImpl(application: Application):RepoOferta{
    private val ofertaDao:OfertaDao by lazy{
        AppDatabase.getDatabase(application)!!.ofertaDao()
    }
    override suspend fun guardarOfer(oferta: Oferta) =ofertaDao.insertOfer(oferta)

    override suspend fun editarOferta(oferta: Oferta) =ofertaDao.updateOfer(oferta)

    override suspend fun borrarOferta(oferta:Oferta)=ofertaDao.deleteOfer(oferta)

}
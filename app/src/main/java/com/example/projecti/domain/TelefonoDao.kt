package com.example.projecti.domain

import androidx.room.*
import com.example.projecti.model.Telefonos
@Dao
interface TelefonoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun guardarTelefonos(telefonos: Telefonos):Long
    //editar mirar si es por id o si es suficiente con el insert replace
    @Update
    suspend fun editarTelefonos(telefonos: Telefonos)
    //borrar
    @Delete
    suspend fun borrarTelefonos(telefonos: Telefonos)

    /*listado de telefonos esta no
    @Query("select * from tabla_telefonos")
    fun listaTelefonos():List<Telefonos>*/
    //empresa y telefonos ,por id

}
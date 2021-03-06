package com.example.projecti.domain

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.projecti.model.Cita
@Dao
interface CitaDao {
    //guardar citas
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun guardarCitas(cita: Cita):Long
    //editar mirar si es por id o si es suficiente con el insert replace
    @Update
    suspend fun editarCitas(cita: Cita)
    //borrar
    @Delete
    suspend fun borrarCitas(cita: Cita)

    //listado de contactos
    @Query("select * from tabla_citas")
    fun listaCitas():LiveData<List<Cita>>
    //empresa y citas ,por id


}
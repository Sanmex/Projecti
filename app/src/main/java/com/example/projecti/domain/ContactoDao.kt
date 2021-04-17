package com.example.projecti.domain

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.projecti.model.Contacto
import com.example.projecti.model.ContactoAndCita
import com.example.projecti.model.ContactoAndTel


@Dao
interface ContactoDao{
    //guardar contacto
    @Insert(onConflict = REPLACE)
    suspend fun guardarContact(contacto:Contacto):Long

    @Query("SELECT id from tabla_contacto order by id DESC limit 1 " )
       fun getById():Long

    @Update
    suspend fun editarContact(contacto: Contacto)
    //borrar
    @Delete
    suspend fun borrarContacto(contacto: Contacto)

    //listado de contactos
    @Query("select * from tabla_contacto order by nombre ")
    fun listaContactos():LiveData<List<Contacto>>



    //empresa y citas ,por id
    @Transaction
    @Query("Select * from tabla_contacto where id=:contactoId")
    fun listaEmpresaCitas(contactoId:Long):LiveData<List<ContactoAndCita>>
    //empresa y telefonos

    @Transaction
    @Query("Select * from tabla_contacto where id=:contactoId")
    fun listaEmpresaTelefonos(contactoId:Long):LiveData<List<ContactoAndTel>>

      //busqueda
    @Query("SELECT * FROM tabla_contacto WHERE nombre LIKE :searchQuery OR nombre LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): LiveData<List<Contacto>>

   //empresaoferta
   /* @Transaction
    @Query("select * from tabla_contacto")
    fun  empresaOferta(oferta:)*/





}
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
    suspend fun guardarContact(contacto:Contacto)
    //editar mirar si es por id o si es suficiente con el insert replace
    @Update
    suspend fun editarContact(contacto: Contacto)
    //borrar
    @Delete
    suspend fun borrarContacto(contacto: Contacto)

    //listado de contactos
    @Query("select * from tabla_contacto")
    fun listaContactos():LiveData<List<Contacto>>

   /* @Query("select *from tabla_contacto where nombre=:bynombre")
    fun empresaByNombre(bynombre:String)*/

    //empresa y citas ,por id
    @Transaction
    @Query("Select * from tabla_contacto where id=:contactoid")
    fun listaEmpresaCitas(contactoid:Long):LiveData<List<ContactoAndCita>>
    //empresa y telefonos

    @Transaction
    @Query("Select * from tabla_contacto where id=:contactoid")
    fun listaEmpresaTelefonos(contactoid:Long):LiveData<List<ContactoAndTel>>

   //empresaoferta
   /* @Transaction
    @Query("select * from tabla_contacto")
    fun  empresaOferta(oferta:)*/




}
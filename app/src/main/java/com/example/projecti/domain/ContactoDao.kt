package com.example.projecti.domain

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.projecti.model.Contacto
import com.example.projecti.model.ContactoAndCita
import com.example.projecti.model.ContactowithTel


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
    fun listaEmpresaCitas(contactoId:Long):LiveData<ContactoAndCita>
    //empresa y telefonos

    @Transaction
    @Query("select * from tabla_contacto  where id=:conid")
    fun getTelecont(conid:Long):LiveData<ContactowithTel>


    //busqueda
    @Query("SELECT * FROM tabla_contacto WHERE nombre LIKE :nombre")
    fun searchDatabase(nombre: String): LiveData<List<Contacto>>


   /*  @Transaction
    @Query("select tabla_telefonos.numero,tabla_telefonos.tipo from tabla_contacto inner join tabla_telefonos where tabla_telefonos.contactoId=tabla_contacto.id and tabla_contacto.id=:conid")
    fun  ofertatelci(conid:Long):List<ContactowithTel>


    @Transaction
    @Query("select tabla_citas.fecha,tabla_citas.estrado from tabla_contacto inner join tabla_citas where tabla_citas.contactoId=tabla_contacto.id and tabla_contacto.id=:conid")
    fun  citaConta(conid:Long):List<ContactoAndCita>*/




}
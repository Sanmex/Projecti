package com.example.projecti.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_contacto")
data class Contacto(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Long,
    @ColumnInfo(name = "nombre")
    val nombre:String,
    @ColumnInfo(name = "direccion")
    val direccion:String,
    @ColumnInfo(name = "mail")
    val mail:String
){
    override fun toString():String=nombre
}
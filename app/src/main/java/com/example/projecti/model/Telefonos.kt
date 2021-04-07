package com.example.projecti.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_telefonos")

data class Telefonos(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id:Long,
    @ColumnInfo(name = "numero")
    val numero:String,
    @ColumnInfo(name = "tipo")
    val tipo:String,
    @ColumnInfo(name = "contactoId")
    val contactoId:Long
)
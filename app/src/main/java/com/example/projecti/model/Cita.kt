package com.example.projecti.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_citas")
data class Cita (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Long,
    @ColumnInfo(name = "nombreem")
    val fecha:String,
    @ColumnInfo(name = "hora")
    val hora:String,
    @ColumnInfo(name = "estrado")
    val estado:String,
    @ColumnInfo(name = "contactoId")
     val contactoId:Long
)
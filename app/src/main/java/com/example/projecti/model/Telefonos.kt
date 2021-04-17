package com.example.projecti.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "tabla_telefonos")
@Parcelize
data class Telefonos(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id:Long,
    @ColumnInfo(name = "numero")
    val numero:String,
    @ColumnInfo(name = "tipo")
    val tipo:String,
    @ColumnInfo(name = "contactoId")
    var contactoId:Long
):Parcelable
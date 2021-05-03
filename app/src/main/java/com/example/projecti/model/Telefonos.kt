package com.example.projecti.model

import android.os.Parcelable
import androidx.room.*
import androidx.room.ForeignKey.CASCADE
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "tabla_telefonos",
   foreignKeys = [
   ForeignKey(
           entity = Contacto::class,
           childColumns = ["contactoId"],
           parentColumns = ["id"]
   )]

)
@Parcelize
data class Telefonos(

    @PrimaryKey(autoGenerate = true)
    var id:Long,
    @ColumnInfo(name = "numero",index = true)
    val numero:String,

    @ColumnInfo(name = "tipo")
    val tipo:String,

    @ColumnInfo(name = "contactoId",index = true)
    var contactoId:Long
):Parcelable
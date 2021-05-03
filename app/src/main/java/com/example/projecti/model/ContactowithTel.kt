package com.example.projecti.model



import androidx.room.Embedded
import androidx.room.Relation
import java.lang.reflect.Constructor

data class ContactowithTel(

        @Embedded val contacto: Contacto,
        @Relation(
    parentColumn = "id",
    entityColumn = "contactoId"


        )
val teles:List<Telefonos> = emptyList()


)


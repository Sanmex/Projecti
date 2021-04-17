package com.example.projecti.model

import androidx.room.Embedded
import androidx.room.Relation

data class ContactoAndTel(
    @Embedded val contacto: Contacto,
    @Relation(
        parentColumn = "id",
        entityColumn = "contactoId"
    )
    val contactoYTels:List<Telefonos>
)

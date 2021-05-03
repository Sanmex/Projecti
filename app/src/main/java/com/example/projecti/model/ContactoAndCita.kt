package com.example.projecti.model

import androidx.room.Embedded
import androidx.room.Relation

data class ContactoAndCita(
    @Embedded val contacto: Contacto,
    @Relation(
        parentColumn="id",
        entityColumn="contactoId"
    )
    val citas:List<Cita>
)





package com.example.projecti.model

data class ContactoComp(
        val id:Long,
        val nombre:String,
        val direccion:String,
        val telefonos:Telefonos,
        val oferta:Oferta,
        val cita: Cita
)
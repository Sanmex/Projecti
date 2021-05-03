package com.example.projecti.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Contactfull (
        val contacto: Contacto,
        val telefonos: Telefonos,
        val oferta: Oferta

):Parcelable
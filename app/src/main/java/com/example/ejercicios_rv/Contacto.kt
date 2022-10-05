package com.example.ejercicios_rv

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contacto(val foto:String, val nombre:String,
                    val correo:String, val telefono:String) : Parcelable {}

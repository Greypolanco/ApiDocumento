package com.example.apidocumento.data.dto

import com.squareup.moshi.Json

data class DocumentoDto(
    @Json(name="NombreCliente")
    val nombreCliente: String,
    @Json(name = "Fecha")
    val fecha: String,
    @Json(name = "Rnc")
    val rnc: String,
    @Json(name = "Monto")
    val monto : Int,
    @Json(name = "Cantidad")
    val cantidad : Double
)

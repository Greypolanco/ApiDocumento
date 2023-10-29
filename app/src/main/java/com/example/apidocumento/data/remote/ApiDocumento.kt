package com.example.apidocumento.data.remote

import com.example.apidocumento.data.dto.DocumentoDto
import retrofit2.http.GET

interface ApiDocumento {
    @GET("documentos")
    suspend fun getDocumentos(): List<DocumentoDto>
}
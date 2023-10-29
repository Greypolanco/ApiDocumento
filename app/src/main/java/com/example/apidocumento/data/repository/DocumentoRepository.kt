package com.example.apidocumento.data.repository

import com.example.apidocumento.data.dto.DocumentoDto
import com.example.apidocumento.data.remote.ApiDocumento
import com.example.apidocumento.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class DocumentoRepository @Inject constructor(
    private val documentoapi : ApiDocumento
) {
    fun getDocumento(): Flow<Resource<List<DocumentoDto>>> = flow{
        try {
            emit(Resource.Loading())

            val documento = documentoapi.getDocumentos()
            emit(Resource.Success(documento))
        }catch (e: HttpException){
            emit(Resource.Error(e.message ?: "Error HTTP"))
        }catch (e: IOException){
            emit(Resource.Error(e.message ?: "Verifica la Conexion"))
        }
    }
}
package com.example.apidocumento.ui.Documento

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.apidocumento.data.dto.DocumentoDto

@Composable
fun DocumentoScreen (viewModel: DocumentoViewModel = hiltViewModel()){
    val documento by viewModel.uiState.collectAsStateWithLifecycle()

    documento.documentos?.let { documento ->
        ConsultaDocumento(documento)
    }

}


@Composable
fun ConsultaDocumento(documentos: List<DocumentoDto>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "Lista de documentos", style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(documentos) { documento ->
                consultaDocumentoItem(documento)
            }
        }
    }
}

@Composable
fun consultaDocumentoItem(documento: DocumentoDto){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(13.dp)
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(13.dp)
        ){
            Text(text ="Nombre:" + documento.nombreCliente)
            Text(text = "Fecha " + documento.fecha)
            Text(text = "RNC: " + documento.rnc)
            Text(text = "Cantidad" + documento.cantidad)
            Text(text = "Monto: " +  documento.monto)
        }
    }
}
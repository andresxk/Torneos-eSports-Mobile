package com.example.torneosesportsmobile.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun ButtonsScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
    ) {
        Text(
            text = "Acciones del Torneo",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Button(
            onClick = { Toast.makeText(context, "Abriendo formulario de inscripción...", Toast.LENGTH_SHORT).show() },
            modifier = Modifier.fillMaxWidth(0.8f)
        ) {
            Text("Inscribir mi Equipo")
        }

        Button(
            onClick = { Toast.makeText(context, "Cargando cuadro de eliminatorias...", Toast.LENGTH_SHORT).show() },
            modifier = Modifier.fillMaxWidth(0.8f)
        ) {
            Text("Ver Cuadro de Torneo")
        }

        Button(
            onClick = { Toast.makeText(context, "Conectando al stream en vivo...", Toast.LENGTH_SHORT).show() },
            modifier = Modifier.fillMaxWidth(0.8f)
        ) {
            Text("Ver Transmisión en Vivo")
        }

        Button(
            onClick = { Toast.makeText(context, "Actualizando ranking de equipos...", Toast.LENGTH_SHORT).show() },
            modifier = Modifier.fillMaxWidth(0.8f)
        ) {
            Text("Tabla de Posiciones")
        }
    }
}

package com.example.torneosesportsmobile.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

data class TournamentPhoto(val id: Int, val url: String, val title: String, val description: String)

@Composable
fun PhotosScreen(modifier: Modifier = Modifier) {
    val photos = listOf(
        TournamentPhoto(1, "https://images.unsplash.com/photo-1542751371-adc38448a05e?q=80&w=2070&auto=format&fit=crop", "Final League of Legends 2025", "Gran final regional disputada en el estadio principal con más de 10,000 asistentes."),
        TournamentPhoto(2, "https://images.unsplash.com/photo-1511512578047-dfb367046420?q=80&w=2071&auto=format&fit=crop", "Setup Setup Gaming", "Configuración de los equipos de alto rendimiento utilizados por los profesionales durante el torneo."),
        TournamentPhoto(3, "https://images.unsplash.com/photo-1534423861386-85a16f5d13fd?q=80&w=2070&auto=format&fit=crop", "Espectadores en Vivo", "La multitud celebrando una victoria espectacular en el último minuto de la partida.")
    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Text(
                text = "Galería de Eventos eSports",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
        items(photos) { photo ->
            PhotoItem(photo = photo)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun PhotoItem(photo: TournamentPhoto) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = !expanded }
    ) {
        Column {
            Image(
                painter = rememberAsyncImagePainter(photo.url),
                contentDescription = photo.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = photo.title,
                    style = MaterialTheme.typography.titleLarge
                )
                
                AnimatedVisibility(visible = expanded) {
                    Text(
                        text = photo.description,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
        }
    }
}

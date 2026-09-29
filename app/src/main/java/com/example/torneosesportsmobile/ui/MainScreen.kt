package com.example.torneosesportsmobile.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.torneosesportsmobile.ui.screens.ButtonsScreen
import com.example.torneosesportsmobile.ui.screens.PhotosScreen
import com.example.torneosesportsmobile.ui.screens.ProfileScreen
import com.example.torneosesportsmobile.ui.screens.VideoScreen
import com.example.torneosesportsmobile.ui.screens.WebScreen

enum class MenuOption {
    PROFILE, PHOTOS, VIDEO, WEB, BUTTONS
}

@Composable
fun MainScreen() {
    var selectedOption by remember { mutableStateOf(MenuOption.PROFILE) }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)) {
            // Panel Izquierdo: Menú
            MenuPanel(
                modifier = Modifier.weight(0.35f),
                selectedOption = selectedOption,
                onOptionSelected = { selectedOption = it }
            )

            // Panel Derecho: Contenido Dinámico
            val contentModifier = Modifier.weight(0.65f)
            when (selectedOption) {
                MenuOption.PROFILE -> ProfileScreen(modifier = contentModifier)
                MenuOption.PHOTOS -> PhotosScreen(modifier = contentModifier)
                MenuOption.VIDEO -> VideoScreen(modifier = contentModifier)
                MenuOption.WEB -> WebScreen(modifier = contentModifier)
                MenuOption.BUTTONS -> ButtonsScreen(modifier = contentModifier)
            }
        }
    }
}

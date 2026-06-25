package com.example.arguide.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.arguide.ui.components.ARBottomBar
import com.example.arguide.ui.components.ARDestination
import com.example.arguide.ui.screens.DashboardScreen
import com.example.arguide.ui.screens.MapScreen
import com.example.arguide.ui.screens.PlaceholderScreen
import com.example.arguide.ui.screens.SearchScreen

@Composable
fun ARGuideApp() {
    var current by remember { mutableStateOf(ARDestination.Inicio) }

    Scaffold(
        bottomBar = {
            ARBottomBar(current = current, onSelect = { current = it })
        }
    ) { innerPadding ->
        val contentModifier = Modifier.padding(bottom = innerPadding.calculateBottomPadding())
        when (current) {
            ARDestination.Inicio -> DashboardScreen(modifier = contentModifier)
            ARDestination.Buscar -> SearchScreen(modifier = contentModifier)
            ARDestination.Mapa -> MapScreen(modifier = contentModifier)
            ARDestination.AR -> PlaceholderScreen(title = "Vista AR", modifier = contentModifier)
            ARDestination.Ajustes -> PlaceholderScreen(title = "Ajustes", modifier = contentModifier)
        }
    }
}

package com.example.arguide.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import com.example.arguide.ui.theme.AROrange
import com.example.arguide.ui.theme.ARSurface
import com.example.arguide.ui.theme.ARTextSecondary

enum class ARDestination(val label: String) {
    Inicio("Inicio"),
    Buscar("Buscar"),
    Mapa("Mapa"),
    AR("AR"),
    Ajustes("Ajustes"),
}

@Composable
fun ARBottomBar(
    current: ARDestination,
    onSelect: (ARDestination) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(72.dp)
            .background(ARSurface)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BarItem(Icons.Filled.Home, ARDestination.Inicio, current, onSelect, Modifier.weight(1f))
            BarItem(Icons.Filled.Search, ARDestination.Buscar, current, onSelect, Modifier.weight(1f))
            Spacer(modifier = Modifier.width(56.dp))
            BarItem(Icons.Filled.Map, ARDestination.Mapa, current, onSelect, Modifier.weight(1f))
            BarItem(Icons.Filled.Settings, ARDestination.Ajustes, current, onSelect, Modifier.weight(1f))
        }

        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .size(56.dp)
                .background(AROrange, CircleShape)
                .clickable { onSelect(ARDestination.AR) },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.CameraAlt,
                contentDescription = "AR",
                tint = Color.White
            )
        }
    }
}

@Composable
private fun BarItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    destination: ARDestination,
    current: ARDestination,
    onSelect: (ARDestination) -> Unit,
    modifier: Modifier = Modifier
) {
    val selected = current == destination
    Box(
        modifier = modifier.clickable { onSelect(destination) },
        contentAlignment = Alignment.Center
    ) {
        androidx.compose.foundation.layout.Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = icon,
                contentDescription = destination.label,
                tint = if (selected) AROrange else ARTextSecondary
            )
            Text(
                text = destination.label,
                style = MaterialTheme.typography.labelSmall,
                color = if (selected) AROrange else ARTextSecondary
            )
        }
    }
}

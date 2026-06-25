package com.example.arguide.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apartment
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.DirectionsRun
import androidx.compose.material.icons.filled.LocalLibrary
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.material.icons.filled.Science
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.arguide.ui.theme.ARSurface
import com.example.arguide.ui.theme.ARSurfaceVariant
import com.example.arguide.ui.theme.ARTextSecondary
import com.example.arguide.ui.theme.AROrange

private data class QuickAccess(val label: String, val icon: androidx.compose.ui.graphics.vector.ImageVector)
private data class Place(val name: String, val distance: String)
private data class RecentRoute(val title: String, val time: String)

private val quickAccess = listOf(
    QuickAccess("Aulas", Icons.Filled.MenuBook),
    QuickAccess("Laboratorios", Icons.Filled.Science),
    QuickAccess("Biblioteca", Icons.Filled.LocalLibrary),
    QuickAccess("Cafetería", Icons.Filled.RestaurantMenu),
    QuickAccess("Deportes", Icons.Filled.DirectionsRun),
)

private val featuredPlaces = listOf(
    Place("Edificio A", "9 45 m"),
    Place("Edificio C", "138 m"),
)

private val recentRoutes = listOf(
    RecentRoute("Lab. Cómputo 2 — Edif. C", "Hace 2 horas"),
    RecentRoute("Biblioteca Ing. Victor Bravo Ahuja", "Ayer"),
    RecentRoute("Servicios Escolares — Edif. A", "Hace 3 días"),
)

@Composable
fun DashboardScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp)
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Filled.Apartment,
                    contentDescription = null,
                    tint = AROrange
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("ARGuide", style = MaterialTheme.typography.titleLarge)
            }
            Row {
                Icon(Icons.Filled.Notifications, contentDescription = "Notificaciones", tint = ARTextSecondary)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .background(ARSurface, RoundedCornerShape(14.dp))
                .padding(horizontal = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Filled.Search, contentDescription = null, tint = ARTextSecondary)
            Spacer(modifier = Modifier.width(8.dp))
            Text("¿A dónde quieres ir?", style = MaterialTheme.typography.bodyLarge, color = ARTextSecondary)
        }

        Spacer(modifier = Modifier.height(20.dp))

        LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            items(quickAccess) { item ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Row(
                        modifier = Modifier
                            .size(52.dp)
                            .background(ARSurface, CircleShape)
                            .clickable { },
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(item.icon, contentDescription = item.label, tint = AROrange)
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(item.label, style = MaterialTheme.typography.labelSmall)
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        SectionHeader(title = "Lugares destacados")
        Spacer(modifier = Modifier.height(12.dp))

        LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            items(featuredPlaces) { place ->
                Card(
                    modifier = Modifier
                        .width(160.dp)
                        .height(110.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = ARSurfaceVariant)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(12.dp),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Text(place.name, style = MaterialTheme.typography.titleMedium)
                        Text(place.distance, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        SectionHeader(title = "Rutas recientes")
        Spacer(modifier = Modifier.height(8.dp))

        Column {
            recentRoutes.forEach { route ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { }
                        .padding(vertical = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(route.title, style = MaterialTheme.typography.bodyLarge)
                        Text(route.time, style = MaterialTheme.typography.bodyMedium)
                    }
                    Icon(Icons.Filled.ChevronRight, contentDescription = null, tint = ARTextSecondary)
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
private fun SectionHeader(title: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
        Text("Ver todos", style = MaterialTheme.typography.bodyMedium, color = AROrange)
    }
}

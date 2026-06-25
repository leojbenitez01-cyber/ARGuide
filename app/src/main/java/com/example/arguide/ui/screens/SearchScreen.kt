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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.arguide.ui.theme.AROrange
import com.example.arguide.ui.theme.ARSurface
import com.example.arguide.ui.theme.ARTextSecondary

private val filters = listOf("Todo", "Edificios", "Laboratorios", "Servicios")
private val suggestions = listOf("Edificio A", "Lab. Cómputo 1", "Sala de reuniones", "Bahía PB Edif. C", "Dirección")
private val recentSearches = listOf("Edificio C", "Cafetería", "Lab. Cómputo 2")

@Composable
fun SearchScreen(modifier: Modifier = Modifier) {
    var selectedFilter by remember { mutableStateOf(filters.first()) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 20.dp)
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .background(ARSurface, RoundedCornerShape(14.dp))
                .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Filled.ArrowBack, contentDescription = "Atrás", tint = ARTextSecondary)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                "Buscar edificio, salón, servicio...",
                style = MaterialTheme.typography.bodyLarge,
                color = ARTextSecondary
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            items(filters) { filter ->
                val isSelected = filter == selectedFilter
                Row(
                    modifier = Modifier
                        .height(36.dp)
                        .background(
                            if (isSelected) AROrange else ARSurface,
                            RoundedCornerShape(20.dp)
                        )
                        .clickable { selectedFilter = filter }
                        .padding(horizontal = 18.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        filter,
                        style = MaterialTheme.typography.bodyMedium,
                        color = if (isSelected) androidx.compose.ui.graphics.Color.White else ARTextSecondary
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        Text("Sugerencias", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(12.dp))

        Column {
            suggestions.forEach { suggestion ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { }
                        .padding(vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Filled.Search, contentDescription = null, tint = ARTextSecondary)
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(suggestion, style = MaterialTheme.typography.bodyLarge)
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Búsquedas recientes", style = MaterialTheme.typography.titleMedium)
            Text("Limpiar", style = MaterialTheme.typography.bodyMedium, color = AROrange)
        }
        Spacer(modifier = Modifier.height(12.dp))

        Column {
            recentSearches.forEach { recent ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { }
                        .padding(vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Filled.History, contentDescription = null, tint = ARTextSecondary)
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(recent, style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
    }
}

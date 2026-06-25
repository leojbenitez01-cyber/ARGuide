package com.example.arguide.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.arguide.ui.theme.ARSurface
import com.example.arguide.ui.theme.AROrange
import com.example.arguide.ui.theme.ARTextSecondary
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.rememberCameraPositionState

private val CampusCenter = LatLng(18.6533, -99.1844)

@Composable
fun MapScreen(modifier: Modifier = Modifier) {
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(CampusCenter, 17f)
    }

    Box(modifier = modifier.fillMaxSize()) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
            properties = remember {
                MapProperties(mapType = MapType.SATELLITE)
            },
            uiSettings = remember {
                MapUiSettings(zoomControlsEnabled = false, myLocationButtonEnabled = false)
            }
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(48.dp)
                .background(ARSurface, RoundedCornerShape(14.dp))
                .padding(horizontal = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Filled.Search, contentDescription = null, tint = ARTextSecondary)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                "Buscar en el campus",
                style = MaterialTheme.typography.bodyLarge,
                color = ARTextSecondary
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(20.dp)
                .size(44.dp)
                .background(ARSurface, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Filled.MyLocation, contentDescription = "Mi ubicación", tint = AROrange)
        }
    }
}

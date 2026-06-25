package com.example.arguide

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng

class MapFragment : Fragment(R.layout.fragment_map), OnMapReadyCallback {

    private val campusCenter = LatLng(18.6533, -99.1844)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val existingMapFragment = childFragmentManager.findFragmentById(R.id.map_container) as? SupportMapFragment
        val mapFragment = existingMapFragment ?: SupportMapFragment.newInstance().also {
            childFragmentManager.beginTransaction().replace(R.id.map_container, it).commit()
        }
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap) {
        map.mapType = GoogleMap.MAP_TYPE_SATELLITE
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(campusCenter, 17f))
        map.uiSettings.isZoomControlsEnabled = false
        map.uiSettings.isMyLocationButtonEnabled = false
    }
}

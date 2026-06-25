package com.example.arguide

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

private data class QuickAccess(val viewId: Int, val label: String, val icon: Int)
private data class RecentRoute(val viewId: Int, val title: String, val time: String)

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private val quickAccessItems = listOf(
        QuickAccess(R.id.qa_aulas, "Aulas", R.drawable.ic_book),
        QuickAccess(R.id.qa_lab, "Laboratorios", R.drawable.ic_science),
        QuickAccess(R.id.qa_biblioteca, "Biblioteca", R.drawable.ic_library),
        QuickAccess(R.id.qa_cafeteria, "Cafetería", R.drawable.ic_restaurant),
        QuickAccess(R.id.qa_deportes, "Deportes", R.drawable.ic_sports),
    )

    private val recentRoutes = listOf(
        RecentRoute(R.id.route_1, "Lab. Cómputo 2 — Edif. C", "Hace 2 horas"),
        RecentRoute(R.id.route_2, "Biblioteca Ing. Victor Bravo Ahuja", "Ayer"),
        RecentRoute(R.id.route_3, "Servicios Escolares — Edif. A", "Hace 3 días"),
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        quickAccessItems.forEach { item ->
            val itemView = view.findViewById<View>(item.viewId)
            itemView.findViewById<ImageView>(R.id.qa_icon).setImageResource(item.icon)
            itemView.findViewById<TextView>(R.id.qa_label).text = item.label
        }

        recentRoutes.forEach { route ->
            val itemView = view.findViewById<View>(route.viewId)
            itemView.findViewById<TextView>(R.id.route_title).text = route.title
            itemView.findViewById<TextView>(R.id.route_time).text = route.time
        }
    }
}

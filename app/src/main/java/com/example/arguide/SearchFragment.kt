package com.example.arguide

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

private data class SearchSuggestion(val viewId: Int, val text: String)
private data class RecentSearch(val viewId: Int, val text: String)

class SearchFragment : Fragment(R.layout.fragment_search) {

    private val suggestions = listOf(
        SearchSuggestion(R.id.sug_1, "Edificio A"),
        SearchSuggestion(R.id.sug_2, "Lab. Cómputo 1"),
        SearchSuggestion(R.id.sug_3, "Sala de reuniones"),
        SearchSuggestion(R.id.sug_4, "Bahía PB Edif. C"),
        SearchSuggestion(R.id.sug_5, "Dirección"),
    )

    private val recentSearches = listOf(
        RecentSearch(R.id.recent_1, "Edificio C"),
        RecentSearch(R.id.recent_2, "Cafetería"),
        RecentSearch(R.id.recent_3, "Lab. Cómputo 2"),
    )

    private val filterIds = listOf(R.id.filter_todo, R.id.filter_edificios, R.id.filter_laboratorios, R.id.filter_servicios)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        suggestions.forEach { suggestion ->
            view.findViewById<View>(suggestion.viewId)
                .findViewById<TextView>(R.id.search_row_text).text = suggestion.text
        }

        recentSearches.forEach { recent ->
            view.findViewById<View>(recent.viewId)
                .findViewById<TextView>(R.id.recent_row_text).text = recent.text
        }

        filterIds.forEach { id ->
            val chip = view.findViewById<TextView>(id)
            chip.setOnClickListener { selectFilter(view, id) }
        }
    }

    private fun selectFilter(root: View, selectedId: Int) {
        filterIds.forEach { id ->
            val chip = root.findViewById<TextView>(id)
            if (id == selectedId) {
                chip.setBackgroundResource(R.drawable.bg_chip_orange)
                chip.setTextColor(resources.getColor(R.color.white, null))
            } else {
                chip.setBackgroundResource(R.drawable.bg_chip_surface)
                chip.setTextColor(resources.getColor(R.color.ar_text_secondary, null))
            }
        }
    }
}

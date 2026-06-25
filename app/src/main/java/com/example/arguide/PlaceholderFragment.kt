package com.example.arguide

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class PlaceholderFragment : Fragment(R.layout.fragment_placeholder) {

    companion object {
        private const val ARG_TITLE = "title"

        fun newInstance(title: String) = PlaceholderFragment().apply {
            arguments = Bundle().apply { putString(ARG_TITLE, title) }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.placeholder_title).text = arguments?.getString(ARG_TITLE) ?: ""
    }
}

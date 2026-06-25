package com.example.arguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.arguide.ui.ARGuideApp
import com.example.arguide.ui.theme.ARGuideTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ARGuideTheme {
                ARGuideApp()
            }
        }
    }
}

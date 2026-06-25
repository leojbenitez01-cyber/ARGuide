package com.example.arguide.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val ARGuideColorScheme = darkColorScheme(
    primary = AROrange,
    onPrimary = ARTextPrimary,
    background = ARBackground,
    onBackground = ARTextPrimary,
    surface = ARSurface,
    onSurface = ARTextPrimary,
    surfaceVariant = ARSurfaceVariant,
    onSurfaceVariant = ARTextSecondary,
    outline = ARDivider,
)

@Composable
fun ARGuideTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = ARBackground.toArgb()
            window.navigationBarColor = ARBackground.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    MaterialTheme(
        colorScheme = ARGuideColorScheme,
        typography = ARGuideTypography,
        content = content
    )
}

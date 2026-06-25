package com.example.arguide.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val ARGuideTypography = Typography(
    titleLarge = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp, color = ARTextPrimary),
    titleMedium = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 17.sp, color = ARTextPrimary),
    bodyLarge = TextStyle(fontWeight = FontWeight.Normal, fontSize = 15.sp, color = ARTextPrimary),
    bodyMedium = TextStyle(fontWeight = FontWeight.Normal, fontSize = 13.sp, color = ARTextSecondary),
    labelSmall = TextStyle(fontWeight = FontWeight.Medium, fontSize = 11.sp, color = ARTextSecondary),
)

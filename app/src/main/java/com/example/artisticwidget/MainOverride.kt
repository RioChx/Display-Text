package com.example.artisticwidget

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

/**
 * THE MAIN OVERRIDE: Single Source of Truth
 * All UI components observe these reactive states.
 */
object MainOverride {
    // LED Text Settings
    var ledText = mutableStateOf("ARTISTIC WIDGET PRO")
    var ledColor = mutableStateOf(Color(android.graphics.Color.parseColor("#00ff00")))
    var ledOffset = mutableStateOf(Offset(50f, 25f))
    
    // Clock Settings (No seconds)
    var clockEnabled = mutableStateOf(true)
    var clockColor = mutableStateOf(Color(android.graphics.Color.parseColor("#ffffff")))
    var clockOffset = mutableStateOf(Offset(50f, 55f))
    var clockScale = mutableStateOf(1.8f)

    // Date Settings
    var dateEnabled = mutableStateOf(true)
    var dateOffset = mutableStateOf(Offset(50f, 80f))
    
    // Global Styling
    var backgroundColor = mutableStateOf(Color(android.graphics.Color.parseColor("#000000")))
    var backgroundOpacity = mutableStateOf(0.85f)
    var widgetWidth = mutableStateOf(350f)
    var widgetHeight = mutableStateOf(200f)
}
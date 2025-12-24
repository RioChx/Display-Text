package com.artistic.widget

import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

object MainOverride {
    // Canvas & Container [cite: 2025-12-13]
    var canvasBgColor by mutableStateOf(Color(0xFF121A16))
    var canvasOpacity by mutableStateOf(0.9f)
    
    // LED Engine (Modes: "Scroll", "Pulse", "Blink", "Rainbow", "Glow Pulse")
    var ledText by mutableStateOf("WIDGET PRO ARTISTIC")
    var ledColor by mutableStateOf(Color(0xFF00FF00))
    var ledFontSize by mutableStateOf(24f)
    var ledAnimSpeed by mutableStateOf(5) // 1-10 Slider
    var ledAnimationMode by mutableStateOf("Glow Pulse")
    var ledOffset by mutableStateOf(Offset(20f, 40f))

    // Clock & Date States [cite: 2025-12-13]
    var showClock by mutableStateOf(true)
    var clockOffset by mutableStateOf(Offset(80f, 100f))
    var showDate by mutableStateOf(true)
    var dateOffset by mutableStateOf(Offset(100f, 180f))
}

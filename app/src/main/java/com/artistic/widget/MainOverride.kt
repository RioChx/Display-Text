package com.artistic.widget

import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

object MainOverride {
    var canvasBgColor by mutableStateOf(Color(0xFF121A16))
    var canvasOpacity by mutableStateOf(0.9f)

    // LED Engine Settings
    var ledText by mutableStateOf("WIDGET PRO ARTISTIC")
    var ledColor by mutableStateOf(Color(0xFF00FF00))
    var ledFontSize by mutableStateOf(24f)
    var ledAnimSpeed by mutableStateOf(5) // 1-10 Slider
    var ledOffset by mutableStateOf(Offset(20f, 40f))
    
    // Animation Mode: "Rainbow", "Pulse", "Blink", or "Static"
    var ledAnimationMode by mutableStateOf("Rainbow") 

    var showClock by mutableStateOf(true)
    var clockOffset by mutableStateOf(Offset(80f, 100f))
}

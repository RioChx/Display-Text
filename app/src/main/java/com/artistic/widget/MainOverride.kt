package com.artistic.widget

import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

object MainOverride {
    // Canvas & Container
    var canvasBgColor by mutableStateOf(Color(0xFF121A16))
    var canvasOpacity by mutableStateOf(0.9f)
    
    // LED Engine (Animations: Scroll, Pulse, Blink, Rainbow, Glow Pulse, Bounce)
    var ledText by mutableStateOf("WIDGET PRO ARTISTIC")
    var ledColor by mutableStateOf(Color(0xFF00FF00))
    var ledFontSize by mutableStateOf(24f)
    var ledAnimSpeed by mutableStateOf(5) // 1-10 Slider
    var ledOffset by mutableStateOf(Offset(20f, 40f))

    // 12h Digital Clock
    var clockColor by mutableStateOf(Color.White)
    var clockOffset by mutableStateOf(Offset(80f, 100f))

    // Date (DD MMM YYYY)
    var dateText by mutableStateOf("24 DEC 2025")
    var dateColor by mutableStateOf(Color.LightGray)
    var dateOffset by mutableStateOf(Offset(100f, 180f))
}

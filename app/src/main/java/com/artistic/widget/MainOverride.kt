package com.artistic.widget

import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

object MainOverride {
    // A. LED Text Engine [cite: 2025-12-13]
    var ledText by mutableStateOf("WIDGET PRO ARTISTIC")
    var ledColor by mutableStateOf(Color(0xFF00FF00))
    var ledFontSize by mutableStateOf(28f)
    var ledAnimationMode by mutableStateOf("Rainbow") // Options: Scroll, Pulse, Blink, Rainbow, Glow, Bounce
    var ledAnimSpeed by mutableStateOf(5) // 1-10 Slider
    var ledOffset by mutableStateOf(Offset(0f, 0f)) // Direct Drag-and-Drop state

    // B. Digital Clock (12h Format) [cite: 2025-12-13]
    var showClock by mutableStateOf(true)
    var clockColor by mutableStateOf(Color.White)
    var clockOffset by mutableStateOf(Offset(0f, -60f))

    // C. Date Display (DD MMM YYYY) [cite: 2025-12-13]
    var showDate by mutableStateOf(true)
    var dateColor by mutableStateOf(Color.Gray)
    var dateOffset by mutableStateOf(Offset(0f, 60f))

    // D. Global Canvas Settings [cite: 2025-12-13]
    var canvasBgColor by mutableStateOf(Color(0xFF0D0D0D))
    var canvasOpacity by mutableStateOf(0.9f)
}

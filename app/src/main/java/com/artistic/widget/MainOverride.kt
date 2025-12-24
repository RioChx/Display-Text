package com.artistic.widget

import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

object MainOverride {
    // 1. Global Canvas Settings
    var canvasWidth by mutableStateOf(350)
    var canvasHeight by mutableStateOf(200)
    var canvasBgColor by mutableStateOf(Color(0xFF121A16))
    var canvasOpacity by mutableStateOf(0.9f)
    var globalScale by mutableStateOf(1.0f)

    // 2. Artistic LED Text Engine
    var ledText by mutableStateOf("WIDGET PRO ARTISTIC")
    var ledColor by mutableStateOf(Color(0xFF00FF00))
    var ledFontSize by mutableStateOf(24f)
    var ledAnimationMode by mutableStateOf("Glow Pulse") // Scroll, Pulse, Blink, Rainbow, Glow, Bounce
    var ledAnimSpeed by mutableStateOf(5) // 1-10 Slider
    var ledOffset by mutableStateOf(Offset(20f, 40f))

    // 3. Digital Clock (12h)
    var showClock by mutableStateOf(true)
    var clockColor by mutableStateOf(Color.White)
    var clockOffset by mutableStateOf(Offset(80f, 100f))

    // 4. Date Display
    var showDate by mutableStateOf(true)
    var dateText by mutableStateOf("24 DEC 2025")
    var dateColor by mutableStateOf(Color.LightGray)
    var dateOffset by mutableStateOf(Offset(100f, 180f))
}

package com.artistic.widget

import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

object MainOverride {
    // Canvas Settings
    var canvasBgColor by mutableStateOf(Color(0xFF121A16))
    var canvasOpacity by mutableStateOf(0.9f)

    // LED Engine (Animations: Rainbow, Pulse, Static)
    var ledText by mutableStateOf("WIDGET PRO ARTISTIC")
    var ledColor by mutableStateOf(Color(0xFF00FF00))
    var ledFontSize by mutableStateOf(24f)
    var ledAnimSpeed by mutableStateOf(5) 
    var ledAnimationMode by mutableStateOf("Rainbow")
    var ledOffset by mutableStateOf(Offset(50f, 50f))

    // Clock Logic
    var showClock by mutableStateOf(true)
    var clockColor by mutableStateOf(Color.White)
    var clockOffset by mutableStateOf(Offset(80f, 120f))
}

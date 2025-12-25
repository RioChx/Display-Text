package com.artistic.widget

import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

object MainOverride {
    var ledText by mutableStateOf("WIDGET PRO ARTISTIC")
    var ledColor by mutableStateOf(Color(0xFFFF00FF)) // Match your pink screenshot
    var ledFontSize by mutableStateOf(28f)
    var ledAnimationMode by mutableStateOf("Rainbow")
    var ledAnimSpeed by mutableStateOf(5)
    var ledOffset by mutableStateOf(Offset(0f, 0f))

    // MISSING CONTROLS START HERE
    var showClock by mutableStateOf(true)
    var showDate by mutableStateOf(true)
    var clockColor by mutableStateOf(Color.White)
    var dateColor by mutableStateOf(Color.Gray)
}

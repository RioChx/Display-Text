package com.artistic.widget

import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

object MainOverride {
    // These 5 variables control the entire APK output
    var ledText by mutableStateOf("WIDGET PRO ARTISTIC")
    var ledColor by mutableStateOf(Color(0xFF00FF00))
    var ledAnimSpeed by mutableStateOf(5) 
    var ledAnimationMode by mutableStateOf("Rainbow") // Rainbow, Pulse, Glow, Static
    var ledOffset by mutableStateOf(Offset(50f, 50f)) // Direct drag-and-drop position
}

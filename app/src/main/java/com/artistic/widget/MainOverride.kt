package com.artistic.widget

import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

object MainOverride {
    // Registry for the Artistic LED Engine
    var ledText by mutableStateOf("WIDGET PRO ARTISTIC")
    var ledColor by mutableStateOf(Color(0xFF00FF00))
    var ledAnimSpeed by mutableStateOf(5) 
    var ledAnimationMode by mutableStateOf("Rainbow") // Rainbow, Pulse, Static
    var ledOffset by mutableStateOf(Offset(50f, 50f))

    // Clock registry
    var showClock by mutableStateOf(true)
    var clockColor by mutableStateOf(Color.White)
    var clockOffset by mutableStateOf(Offset(80f, 120f))
}

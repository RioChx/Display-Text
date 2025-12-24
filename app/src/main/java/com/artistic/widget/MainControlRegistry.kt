package com.artistic.widget

import androidx.compose.runtime.*

object MainControlRegistry {
    // These update in real-time as you drag elements on screen
    var clockX by mutableStateOf(0f)
    var clockY by mutableStateOf(0f)
    
    var dateX by mutableStateOf(0f)
    var dateY by mutableStateOf(100f)
}

package com.artistic.widget

import androidx.compose.runtime.*

object MainControlRegistry {
    // Central source of truth for your coordinates
    var clockX by mutableStateOf(100f)
    var clockY by mutableStateOf(100f)
    
    // Changing this string updates the UI immediately
    var ledText by mutableStateOf("Digital Art")
}

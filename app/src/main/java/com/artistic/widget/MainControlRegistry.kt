package com.artistic.widget

import androidx.compose.runtime.*

object MainControlRegistry {
    // Central source of truth for Drag-and-Drop
    var clockX by mutableStateOf(100f)
    var clockY by mutableStateOf(100f)
    
    // Global LED settings
    var ledText by mutableStateOf("Digital Art")
}

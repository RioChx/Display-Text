package com.artistic.widget

import androidx.compose.runtime.*

object MainControlRegistry {
    // These hold the Drag-and-Drop positions
    var clockX by mutableStateOf(0f)
    var clockY by mutableStateOf(0f)
    
    // Global LED settings
    var ledText by mutableStateOf("Digital Art")
}

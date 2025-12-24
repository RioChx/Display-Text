package com.artistic.widget

import androidx.compose.runtime.*

object MainControlRegistry {
    // These coordinates are used by both the App and the Widget
    var clockX by mutableStateOf(150f)
    var clockY by mutableStateOf(150f)
    
    // Changing this text here overrides the text in the whole project [cite: 2025-12-13]
    var ledText by mutableStateOf("Digital Art Active")
}

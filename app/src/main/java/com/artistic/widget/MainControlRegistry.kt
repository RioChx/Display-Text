package com.artistic.widget

import androidx.compose.runtime.*

object MainControlRegistry {
    // These variables store the live position of the text
    var clockX by mutableStateOf(100f)
    var clockY by mutableStateOf(100f)
    
    // Changing this string updates the app immediately
    var ledText by mutableStateOf("Digital Art")
}

package com.artistic.widget

import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Offset

object MainControlRegistry {
    // This stores the final "Dropped" position from your drag-and-drop action
    var droppedPosition by mutableStateOf(Offset(100f, 100f))
    
    // Changing this text here updates the draggable item everywhere [cite: 2025-12-13]
    var dragItemText by mutableStateOf("Drag Me Anywhere")
}

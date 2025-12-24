package com.example.artisticwidget

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

object MainOverride {
    // LED TEXT GLOBAL SETTINGS
    var ledText by mutableStateOf("25 Dec 2025")
    var ledColor by mutableStateOf(Color.Cyan)
    
    // DRAG-AND-DROP COORDINATES (The State Sync)
    // These are updated in real-time by the Drag Hooks
    var clockX by mutableStateOf(0f)
    var clockY by mutableStateOf(0f)
    
    var dateX by mutableStateOf(0f)
    var dateY by mutableStateOf(100f)
    
    var ledX by mutableStateOf(0f)
    var ledY by mutableStateOf(-100f)
}

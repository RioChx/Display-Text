package com.example.artisticwidget
import androidx.compose.runtime.*

object MainOverride {
    // These values are updated by your drag gestures
    var clockX by mutableStateOf(0f)
    var clockY by mutableStateOf(0f)
    
    var dateX by mutableStateOf(0f)
    var dateY by mutableStateOf(100f)
}

package com.artistic.widget

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Dark background ensures visibility
            Box(modifier = Modifier.fillMaxSize().background(Color(0xFF1A1A1A))) {
                Text(
                    text = MainControlRegistry.ledText,
                    color = Color.Cyan,
                    fontSize = 40.sp,
                    modifier = Modifier
                        .offset { 
                            IntOffset(
                                MainControlRegistry.clockX.roundToInt(), 
                                MainControlRegistry.clockY.roundToInt()
                            ) 
                        }
                        .pointerInput(Unit) {
                            detectDragGestures { change, dragAmount ->
                                change.consume()
                                // Updates the central Registry [cite: 2025-12-13]
                                MainControlRegistry.clockX += dragAmount.x
                                MainControlRegistry.clockY += dragAmount.y
                            }
                        }
                )
            }
        }
    }
}

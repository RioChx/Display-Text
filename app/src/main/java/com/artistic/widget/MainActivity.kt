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
            // Background canvas for the drop zone
            Box(modifier = Modifier.fillMaxSize().background(Color(0xFF1A1A1A))) {
                Text(
                    text = MainControlRegistry.dragItemText,
                    color = Color.Cyan,
                    fontSize = 32.sp,
                    modifier = Modifier
                        .offset { 
                            IntOffset(
                                MainControlRegistry.droppedPosition.x.roundToInt(), 
                                MainControlRegistry.droppedPosition.y.roundToInt()
                            ) 
                        }
                        .pointerInput(Unit) {
                            detectDragGestures { change, dragAmount ->
                                change.consume()
                                // Logic: As you drag, we update the Main Override [cite: 2025-12-13]
                                val newX = MainControlRegistry.droppedPosition.x + dragAmount.x
                                val newY = MainControlRegistry.droppedPosition.y + dragAmount.y
                                MainControlRegistry.droppedPosition = androidx.compose.ui.geometry.Offset(newX, newY)
                            }
                        }
                )
            }
        }
    }
}

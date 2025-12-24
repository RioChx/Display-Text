package com.example.artisticwidget

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Main Container allowing free X/Y positioning
            Box(modifier = Modifier.fillMaxSize()) {
                
                // 1. DRAGGABLE CLOCK
                Text(
                    text = "12:00 AM",
                    fontSize = 40.sp,
                    color = MainOverride.ledColor,
                    modifier = Modifier
                        .offset { IntOffset(MainOverride.clockX.roundToInt(), MainOverride.clockY.roundToInt()) }
                        .pointerInput(Unit) {
                            detectDragGestures { change, dragAmount ->
                                change.consume()
                                // The Hook: Writing directly back to Main Override
                                MainOverride.clockX += dragAmount.x
                                MainOverride.clockY += dragAmount.y
                            }
                        }
                )

                // 2. DRAGGABLE DATE
                Text(
                    text = MainOverride.ledText,
                    fontSize = 20.sp,
                    color = MainOverride.ledColor,
                    modifier = Modifier
                        .offset { IntOffset(MainOverride.dateX.roundToInt(), MainOverride.dateY.roundToInt()) }
                        .pointerInput(Unit) {
                            detectDragGestures { change, dragAmount ->
                                change.consume()
                                // The Hook: Keeping State Sync
                                MainOverride.dateX += dragAmount.x
                                MainOverride.dateY += dragAmount.y
                            }
                        }
                )
            }
        }
    }
}

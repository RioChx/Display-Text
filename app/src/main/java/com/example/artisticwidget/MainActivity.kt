package com.example.artisticwidget
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(Modifier.fillMaxSize()) {
                Text(
                    text = "12:00 AM",
                    modifier = Modifier
                        .offset { IntOffset(MainOverride.clockX.roundToInt(), MainOverride.clockY.roundToInt()) }
                        .pointerInput(Unit) {
                            detectDragGestures { _, dragAmount ->
                                // THE HOOK: Updating Main Override in real-time
                                MainOverride.clockX += dragAmount.x
                                MainOverride.clockY += dragAmount.y
                            }
                        }
                )
            }
        }
    }
}

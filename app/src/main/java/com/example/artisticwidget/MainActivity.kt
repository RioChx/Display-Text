package com.example.artisticwidget

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
            ) {
                WidgetPreview()
            }
        }
    }
}

@Composable
fun WidgetPreview() {
    val config = MainOverride
    
    Box(
        modifier = Modifier
            .size(config.widgetWidth.value.dp, config.widgetHeight.value.dp)
            .background(config.backgroundColor.value.copy(alpha = config.backgroundOpacity.value))
    ) {
        // DRAGGABLE LED TEXT
        Text(
            text = config.ledText.value,
            color = config.ledColor.value,
            fontSize = 24.sp,
            modifier = Modifier
                .offset { IntOffset(config.ledOffset.value.x.roundToInt(), config.ledOffset.value.y.roundToInt()) }
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()
                        config.ledOffset.value += dragAmount
                    }
                }
        )

        // DRAGGABLE CLOCK (No seconds)
        if (config.clockEnabled.value) {
            Text(
                text = "12:00", // Dynamic time logic goes here
                color = config.clockColor.value,
                fontSize = (32 * config.clockScale.value).sp,
                modifier = Modifier
                    .offset { IntOffset(config.clockOffset.value.x.roundToInt(), config.clockOffset.value.y.roundToInt()) }
                    .pointerInput(Unit) {
                        detectDragGestures { change, dragAmount ->
                            change.consume()
                            config.clockOffset.value += dragAmount
                        }
                    }
            )
        }
    }
}
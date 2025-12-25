package com.artistic.widget

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(modifier = Modifier.fillMaxSize().background(Color(0xFF0D0D0D)), contentAlignment = Alignment.Center) {
                WidgetPreview()
            }
        }
    }
}

@Composable
fun WidgetPreview() {
    val infiniteTransition = rememberInfiniteTransition(label = "Anims")
    
    // Rainbow Color Shift
    val rainbowColor by infiniteTransition.animateColor(
        initialValue = Color.Cyan, targetValue = Color.Magenta,
        animationSpec = infiniteRepeatable(tween(2000), RepeatMode.Reverse), label = "Rainbow"
    )

    // 1Hz Colon Blink
    val blinkAlpha by infiniteTransition.animateFloat(
        initialValue = 1f, targetValue = 0f,
        animationSpec = infiniteRepeatable(tween(1000), RepeatMode.Reverse), label = "Blink"
    )

    Box(
        modifier = Modifier
            .size(350.dp, 200.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(MainOverride.canvasBgColor.copy(alpha = MainOverride.canvasOpacity))
    ) {
        // Draggable LED
        DraggableLayer(MainOverride.ledOffset, { MainOverride.ledOffset = it }) {
            Text(
                text = MainOverride.ledText,
                color = if (MainOverride.ledAnimationMode == "Rainbow") rainbowColor else MainOverride.ledColor,
                fontSize = MainOverride.ledFontSize.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // Draggable Clock
        if (MainOverride.showClock) {
            DraggableLayer(MainOverride.clockOffset, { MainOverride.clockOffset = it }) {
                Row {
                    Text("11", color = MainOverride.clockColor, fontSize = 58.sp, fontWeight = FontWeight.Bold)
                    Text(":", color = MainOverride.clockColor.copy(alpha = blinkAlpha), fontSize = 58.sp, fontWeight = FontWeight.Bold)
                    Text("24", color = MainOverride.clockColor, fontSize = 58.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun DraggableLayer(offset: Offset, onMove: (Offset) -> Unit, content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .offset { IntOffset(offset.x.roundToInt(), offset.y.roundToInt()) }
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    // Sync back to Main Override Registry [cite: 2025-12-13]
                    onMove(Offset(offset.x + dragAmount.x, offset.y + dragAmount.y))
                }
            }
    ) { content() }
}

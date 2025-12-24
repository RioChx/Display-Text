package com.artistic.widget

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
                WidgetCanvas()
            }
        }
    }
}

@Composable
fun WidgetCanvas() {
    val infiniteTransition = rememberInfiniteTransition(label = "StudioAnims")
    
    // 1Hz Colon Blink Logic [cite: 2025-12-13]
    val blinkAlpha by infiniteTransition.animateFloat(
        initialValue = 1f, targetValue = 0f,
        animationSpec = infiniteRepeatable(tween(1000), RepeatMode.Reverse), label = "ClockBlink"
    )

    // Glow Pulse Logic
    val glowIntensity by infiniteTransition.animateDp(
        initialValue = 2.dp, targetValue = 12.dp,
        animationSpec = infiniteRepeatable(tween(2000 / MainOverride.ledAnimSpeed), RepeatMode.Reverse), label = "Neon"
    )

    Box(
        modifier = Modifier
            .size(350.dp, 200.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(MainOverride.canvasBgColor.copy(alpha = MainOverride.canvasOpacity))
    ) {
        // Draggable LED Layer [cite: 2025-12-13]
        DraggableLayer(MainOverride.ledOffset, { MainOverride.ledOffset = it }) {
            Text(
                text = MainOverride.ledText,
                color = MainOverride.ledColor,
                fontSize = MainOverride.ledFontSize.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.shadow(glowIntensity, Color.Transparent, ambientColor = MainOverride.ledColor)
            )
        }

        // Draggable Clock Layer [cite: 2025-12-13]
        if (MainOverride.showClock) {
            DraggableLayer(MainOverride.clockOffset, { MainOverride.clockOffset = it }) {
                Row {
                    Text("11", color = Color.White, fontSize = 54.sp, fontWeight = FontWeight.Bold)
                    Text(":", color = Color.White.copy(alpha = blinkAlpha), fontSize = 54.sp, fontWeight = FontWeight.Bold)
                    Text("24", color = Color.White, fontSize = 54.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun DraggableLayer(offset: androidx.compose.ui.geometry.Offset, onMove: (androidx.compose.ui.geometry.Offset) -> Unit, content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .offset { IntOffset(offset.x.roundToInt(), offset.y.roundToInt()) }
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    // Sync back to MainOverride registry [cite: 2025-12-13, 2025-12-19]
                    onMove(androidx.compose.ui.geometry.Offset(offset.x + dragAmount.x, offset.y + dragAmount.y))
                }
            }
    ) { content() }
}

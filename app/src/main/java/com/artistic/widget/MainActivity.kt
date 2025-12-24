package com.artistic.widget

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
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
import java.util.*
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Main Canvas
            Box(modifier = Modifier.fillMaxSize().background(Color(0xFF0D0D0D)), contentAlignment = Alignment.Center) {
                WidgetCanvas()
            }
        }
    }
}

@Composable
fun WidgetCanvas() {
    val infiniteTransition = rememberInfiniteTransition(label = "GlobalAnim")
    
    // 1Hz Blink Logic for Clock Colon
    val blinkAlpha by infiniteTransition.animateFloat(
        initialValue = 1f, targetValue = 0f,
        animationSpec = infiniteRepeatable(animationStep(1000), RepeatMode.Reverse), label = "ColonBlink"
    )

    // Glow Pulse Animation for LED
    val glowRadius by infiniteTransition.animateDp(
        initialValue = 2.dp, targetValue = 12.dp,
        animationSpec = infiniteRepeatable(tween(1500 / MainOverride.ledAnimSpeed), RepeatMode.Reverse), label = "Glow"
    )

    Box(
        modifier = Modifier
            .size(MainOverride.canvasWidth.dp, MainOverride.canvasHeight.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(MainOverride.canvasBgColor.copy(alpha = MainOverride.canvasOpacity))
            .shadow(glowRadius, RoundedCornerShape(20.dp), ambientColor = MainOverride.ledColor)
    ) {
        // LED Text Element
        DraggableLayer(MainOverride.ledOffset, { MainOverride.ledOffset = it }) {
            Text(
                text = MainOverride.ledText,
                color = MainOverride.ledColor,
                fontSize = MainOverride.ledFontSize.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.shadow(if(MainOverride.ledAnimationMode == "Glow Pulse") glowRadius else 0.dp, Color.Transparent)
            )
        }

        // Digital Clock Element
        if (MainOverride.showClock) {
            DraggableLayer(MainOverride.clockOffset, { MainOverride.clockOffset = it }) {
                Row {
                    Text("11", color = MainOverride.clockColor, fontSize = 54.sp, fontWeight = FontWeight.Bold)
                    Text(":", color = MainOverride.clockColor.copy(alpha = blinkAlpha), fontSize = 54.sp, fontWeight = FontWeight.Bold)
                    Text("24", color = MainOverride.clockColor, fontSize = 54.sp, fontWeight = FontWeight.Bold)
                }
            }
        }

        // Date Display
        if (MainOverride.showDate) {
            DraggableLayer(MainOverride.dateOffset, { MainOverride.dateOffset = it }) {
                Text(text = MainOverride.dateText, color = MainOverride.dateColor, fontSize = 16.sp)
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
                    onMove(Offset(offset.x + dragAmount.x, offset.y + dragAmount.y))
                }
            }
    ) { content() }
}

fun animationStep(duration: Int) = tween<Float>(duration, easing = LinearEasing)

package com.artistic.widget

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(colorScheme = darkColorScheme()) {
                Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFF080808)) {
                    StudioRoot()
                }
            }
        }
    }
}

@Composable
fun StudioRoot() {
    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
        // --- SECTION 1: THE PREVIEW CANVAS (Drag & Drop) ---
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .background(MainOverride.canvasBgColor.copy(alpha = MainOverride.canvasOpacity)),
            contentAlignment = Alignment.Center
        ) {
            // LED Text Component with Rainbow Animation
            val infiniteTransition = rememberInfiniteTransition(label = "FX")
            val rainbowColor by infiniteTransition.animateColor(
                initialValue = Color.Cyan,
                targetValue = Color.Magenta,
                animationSpec = infiniteRepeatable(
                    animation = tween(2000 / MainOverride.ledAnimSpeed.coerceAtLeast(1)),
                    repeatMode = RepeatMode.Reverse
                ), label = "Rainbow"
            )

            DraggableElement(
                offset = MainOverride.ledOffset,
                onMove = { MainOverride.ledOffset += it }
            ) {
                Text(
                    text = MainOverride.ledText,
                    color = if (MainOverride.ledAnimationMode == "Rainbow") rainbowColor else MainOverride.ledColor,
                    fontSize = MainOverride.ledFontSize.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        // --- SECTION 2: THE CONTROL PANEL ---
        ControlPanel()
    }
}

@Composable
fun DraggableElement(offset: androidx.compose.ui.geometry.Offset, onMove: (androidx.compose.ui.geometry.Offset) -> Unit, content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .offset { IntOffset(offset.x.roundToInt(), offset.y.roundToInt()) }
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    onMove(dragAmount)
                }
            }
    ) { content() }
}

@Composable
fun ControlPanel() {
    Column(modifier = Modifier.padding(20.dp)) {
        Text("ARTISTIC ENGINE", color = Color.Cyan, fontWeight = FontWeight.Bold)
        
        OutlinedTextField(
            value = MainOverride.ledText,
            onValueChange = { MainOverride.ledText = it },
            label = { Text("LED Text Content") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text("Animation Speed: ${MainOverride.ledAnimSpeed}", color = Color.White)
        Slider(
            value = MainOverride.ledAnimSpeed.toFloat(),
            onValueChange = { MainOverride.ledAnimSpeed = it.toInt() },
            valueRange = 1f..10f
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        Text("Canvas Transparency", color = Color.White)
        Slider(
            value = MainOverride.canvasOpacity,
            onValueChange = { MainOverride.canvasOpacity = it }
        )
    }
}

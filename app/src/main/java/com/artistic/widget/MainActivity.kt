package com.artistic.widget

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import kotlinx.coroutines.delay
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(colorScheme = darkColorScheme()) {
                Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFF080808)) {
                    AdvancedStudioRoot()
                }
            }
        }
    }
}

@Composable
fun AdvancedStudioRoot() {
    // Logic for the Blinking Colon (1Hz) [cite: 2025-12-25]
    var showColon by remember { mutableStateOf(true) }
    LaunchedEffect(Unit) {
        while(true) {
            delay(500)
            showColon = !showColon
        }
    }

    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
        // --- 1. THE PREVIEW CANVAS ---
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .background(MainOverride.canvasBgColor.copy(alpha = MainOverride.canvasOpacity)),
            contentAlignment = Alignment.Center
        ) {
            // Gear Icon (Launch Controls) [cite: 2025-12-25]
            Text("⚙", modifier = Modifier.align(Alignment.TopStart).padding(16.dp), color = Color.White, fontSize = 24.sp)
            
            // X Icon (Close) [cite: 2025-12-25]
            Text("✕", modifier = Modifier.align(Alignment.TopEnd).padding(16.dp), color = Color.White, fontSize = 24.sp)

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                // Clock (12h Format) [cite: 2025-12-25]
                if (MainOverride.showClock) {
                    val colon = if (showColon) ":" else " "
                    Text("12${colon}00", color = MainOverride.clockColor, fontSize = 52.sp, fontWeight = FontWeight.Bold)
                }
                
                // Date (DD MMM YYYY) [cite: 2025-12-25]
                if (MainOverride.showDate) {
                    Text("25 DEC 2025", color = MainOverride.dateColor, fontSize = 18.sp)
                }

                Spacer(modifier = Modifier.height(24.dp))

                // LED Text with Drag-and-Drop [cite: 2025-12-13, 2025-12-25]
                Text(
                    text = MainOverride.ledText,
                    color = MainOverride.ledColor,
                    fontSize = MainOverride.ledFontSize.sp,
                    modifier = Modifier
                        .offset { IntOffset(MainOverride.ledOffset.x.roundToInt(), MainOverride.ledOffset.y.roundToInt()) }
                        .pointerInput(Unit) {
                            detectDragGestures { change, dragAmount ->
                                change.consume()
                                MainOverride.ledOffset += dragAmount
                            }
                        }
                )
            }
        }

        // --- 2. CONTROL PANEL ---
        Column(modifier = Modifier.padding(20.dp)) {
            Text("GLOBAL OVERRIDE", color = Color.Cyan, fontWeight = FontWeight.ExtraBold)
            
            // Visibility Switches [cite: 2025-12-13]
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = MainOverride.showClock, onCheckedChange = { MainOverride.showClock = it })
                Text("Show Digital Clock", color = Color.White)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = MainOverride.showDate, onCheckedChange = { MainOverride.showDate = it })
                Text("Show Date Layer", color = Color.White)
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Text Input
            OutlinedTextField(
                value = MainOverride.ledText,
                onValueChange = { MainOverride.ledText = it },
                label = { Text("Artistic LED Text") },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

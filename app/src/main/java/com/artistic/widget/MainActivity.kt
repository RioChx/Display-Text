package com.artistic.widget

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Background Box to ensure we aren't seeing black-on-black
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.DarkGray)) {
                
                Text(
                    text = "Widget Control Active",
                    color = Color.White,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(16.dp)
                )
                
                // Your Drag-and-Drop logic goes here
            }
        }
    }
}

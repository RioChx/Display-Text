@Composable
fun StudioRoot() {
    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
        // --- THE PREVIEW CANVAS WITH NAVIGATION ICONS ---
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(Color(0xFF0D0D0D)),
            contentAlignment = Alignment.Center
        ) {
            // 1. Close Icon (Top Right)
            IconButton(
                onClick = { /* Logic to hide widget */ },
                modifier = Modifier.align(Alignment.TopEnd).padding(10.dp)
            ) {
                Text("✕", color = Color.White, fontSize = 20.sp)
            }

            // 2. Settings Icon (Top Left)
            IconButton(
                onClick = { /* Already in settings */ },
                modifier = Modifier.align(Alignment.TopStart).padding(10.dp)
            ) {
                Text("⚙", color = Color.White, fontSize = 20.sp)
            }

            // 3. Digital Clock Layer (Missing in your screenshot)
            if (MainOverride.showClock) {
                Text(
                    text = "12:00", 
                    color = MainOverride.clockColor,
                    modifier = Modifier.offset(y = (-60).dp),
                    fontSize = 40.sp
                )
            }

            // 4. LED Text (As seen in your screenshot)
            Text(
                text = MainOverride.ledText,
                color = MainOverride.ledColor,
                fontSize = MainOverride.ledFontSize.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // --- THE MISSING CONTROL SWITCHES ---
        Column(modifier = Modifier.padding(20.dp)) {
            Text("WIDGET LAYOUT", color = Color.Cyan, fontWeight = FontWeight.Bold)
            
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = MainOverride.showClock, onCheckedChange = { MainOverride.showClock = it })
                Text("Enable Digital Clock", color = Color.White)
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = MainOverride.showDate, onCheckedChange = { MainOverride.showDate = it })
                Text("Enable Date Display", color = Color.White)
            }

            Spacer(modifier = Modifier.height(20.dp))
            Text("LED SETTINGS", color = Color.Cyan, fontWeight = FontWeight.Bold)
            // ... (Your existing TextFields and Sliders go here)
        }
    }
}

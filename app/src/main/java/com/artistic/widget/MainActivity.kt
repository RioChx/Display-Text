@Composable
fun StudioRoot() {
    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
        // --- PREVIEW CANVAS ---
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(Color.Black),
            contentAlignment = Alignment.Center
        ) {
            // 1. Gear Icon (Open Controls)
            Text("⚙", modifier = Modifier.align(Alignment.TopStart).padding(16.dp), color = Color.Gray, fontSize = 24.sp)
            
            // 2. X Icon (Close)
            Text("✕", modifier = Modifier.align(Alignment.TopEnd).padding(16.dp), color = Color.Gray, fontSize = 24.sp)

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                // Digital Clock Logic (12h format)
                if (MainOverride.showClock) {
                    Text("12:00", color = MainOverride.clockColor, fontSize = 48.sp, fontWeight = FontWeight.Bold)
                }
                // Date Logic
                if (MainOverride.showDate) {
                    Text("25 DEC 2025", color = MainOverride.dateColor, fontSize = 16.sp)
                }
                Spacer(modifier = Modifier.height(20.dp))
                // LED Text
                Text(
                    text = MainOverride.ledText,
                    color = MainOverride.ledColor,
                    fontSize = MainOverride.ledFontSize.sp,
                    modifier = Modifier.offset { IntOffset(MainOverride.ledOffset.x.roundToInt(), MainOverride.ledOffset.y.roundToInt()) }
                )
            }
        }

        // --- NEW MODULE CONTROLS ---
        Column(modifier = Modifier.padding(20.dp)) {
            Text("MODULE VISIBILITY", color = Color.Cyan, fontWeight = FontWeight.Bold)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = MainOverride.showClock, onCheckedChange = { MainOverride.showClock = it })
                Text("Enable Digital Clock", color = Color.White)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = MainOverride.showDate, onCheckedChange = { MainOverride.showDate = it })
                Text("Enable Date Display", color = Color.White)
            }
            
            Spacer(modifier = Modifier.height(20.dp))
            Text("LED TEXT SETTINGS", color = Color.Cyan, fontWeight = FontWeight.Bold)
            OutlinedTextField(
                value = MainOverride.ledText,
                onValueChange = { MainOverride.ledText = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Content") }
            )
        }
    }
}

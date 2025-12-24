package com.artistic.widget

import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * THE MAIN OVERRIDE: Configuration Registry for the Artistic LED & Clock.
 * Observed reactively by both the App and the Home Screen Widget.
 */
object MainControlRegistry {
    data class WidgetSettings(
        val ledText: String = "ARTISTIC WIDGET PRO",
        val ledColor: Color = Color(android.graphics.Color.parseColor("#00ff00")),
        val ledPos: Pair<Float, Float> = 50f to 25f,
        val clockEnabled: Boolean = true,
        val clockPos: Pair<Float, Float> = 50f to 55f,
        val dateEnabled: Boolean = true,
        val datePos: Pair<Float, Float> = 50f to 80f,
        val backgroundColor: Color = Color(android.graphics.Color.parseColor("#000000")),
        val opacity: Float = 0.85f
    )

    private val _settings = MutableStateFlow(WidgetSettings())
    val settings = _settings.asStateFlow()

    fun updateSettings(newSettings: WidgetSettings) {
        _settings.value = newSettings
    }
}